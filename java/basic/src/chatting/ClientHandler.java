package chatting;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClientHandler implements Runnable {
	private String nickname;
	private Socket client;
	private DataOutputStream out;
	private DataInputStream in;
	private ChatRoom room;

	public ClientHandler(Socket socket) {
		this.client = socket;
	}

	public void printMessage(String msg) {
		try {
			out.writeUTF(msg + ColorPrint.RESET);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean isNickNameValidate(String nickname) {
		return room.getMember(nickname) == null;
	}

	public void printHelpMessage() {
		String str = "<도움말>\n"
			+ "=========================================\n"
			+ ColorPrint.YELLOW + "/h 또는 /도: " + ColorPrint.RESET + "도움말\n"
			+ ColorPrint.YELLOW + "/n 또는 /별 닉네임: " + ColorPrint.RESET + "별명 바꾸기\n"
			+ ColorPrint.YELLOW + "/e 또는 /귓 보낼 유저 보낼 내용: " + ColorPrint.RESET + "귓속말 하기\n"
			+ ColorPrint.YELLOW + "/q 또는 /가: " + ColorPrint.RESET + "방에서 나가기\n";

		printMessage(str);
	}

	public void help(String input) {
		String[] tokens = input.split(" ", 2);
		System.out.println("명령어" + tokens[0]);
		String command = tokens[0];
		//두 번째 토큰은 귓말 or 새 닉네임
		String arg = tokens.length > 1 ? tokens[1] : null;
		switch (command) {
			case "/h", "/도": //도움말 출력
				printHelpMessage();
				break;
			case "/n", "/별": //별명 바꾸기
				if (arg != null && !arg.isBlank()) {
					String newNickName = arg.trim();
					if (isNickNameValidate(newNickName)) {
						this.nickname = newNickName;
						printMessage(ColorPrint.BLUE + "닉네임이 " + this.nickname + " 으로 변경되었습니다");
					} else {
						printMessage("이미 존재하는 닉네임입니다");
					}
				} else {
					printMessage("닉네임을 올바르게 입력하세요 예: /h 자바가조아");
				}
				break;
			case "/e", "/귓": //귓속말 하기
				if (arg == null || !arg.contains(" ")) {
					printMessage("귓속말 사용법 예: /e 민지 이거 귓속말이얌");
				} else {
					//닉네임 + 귓속말 부분 한 번 자르기
					String[] whisperParts = arg.split(" ", 2);
					String targetName = whisperParts[0];
					String message = whisperParts[1];

					ClientHandler target = room.getMember(targetName);
					if (target != null) {
						target.printMessage(ColorPrint.PURPLE + "(귓속말) " + this.nickname + ": " + message);
						this.printMessage(ColorPrint.PURPLE + "(귓속말): " + message);
					} else {
						printMessage("해당 유저를 찾을 수 없습니다: " + targetName);
					}
				}
				break;
			default:
				printMessage("알 수 없는 명령어입니다 /h나 /도 를 입력해서 도움말을 읽어 보세요");
				break;
		}
	}

	@Override
	public void run() {
		try {
			this.in = new DataInputStream(this.client.getInputStream());
			this.out = new DataOutputStream(client.getOutputStream());
			while (true) {
				//방 입장/방 생성 루프
				out.writeUTF(ColorPrint.YELLOW + Server.getFormattedRoomList());
				out.writeUTF("입장할 방 이름을 입력하세요. (존재하지 않으면 새로 생성됩니다)");

				String roomName = in.readUTF().trim();
				ChatRoom room = Server.getOrCreateRoom(roomName);

				// 3. 닉네임 설정 요청
				out.writeUTF("이 방에서 사용할 닉네임을 입력하세요:");
				String nicknameInput = in.readUTF().trim();
				if (room.getMember(nicknameInput) != null) {
					out.writeUTF("이미 사용 중인 닉네임입니다. 다시 시도하세요.");
					continue;
				}

				this.room = room;
				this.nickname = nicknameInput;
				room.join(this); // 현재 클라이언트를 방에 등록

				while (true) {
					//방 안에서 채팅하는 루프
					String msg = in.readUTF();
					if (msg.startsWith("/")) {
						if (msg.startsWith("/q") || msg.startsWith("/가")) {
							room.leave(this);
							break;
						}
						help(msg);
						continue;
					}
					room.sendMessage(msg, this.nickname);
				}
			}

		} catch (Exception e) {
			room.broadcast(this.nickname + " 님의 연결이 끊겼습니다\n", this);
			room.leave(this);
		}
	}
}