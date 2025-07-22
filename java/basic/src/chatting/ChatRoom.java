package chatting;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class ChatRoom {
	private final String name;
	private final List<ClientHandler> users = new ArrayList<>();

	public ChatRoom(String name) {
		this.name = name;
	}

	public void join(ClientHandler client) {
		users.add(client);
		client.printMessage(ColorPrint.BLUE + "'" + this.name + "' 방에 입장하셨습니다");
		broadcast(ColorPrint.BLUE + client.getNickname() + " 님이 입장했습니다.", client);
	}

	public void leave(ClientHandler client) {
		users.remove(client);
		broadcast(ColorPrint.BLUE + client.getNickname() + " 님이 퇴장했습니다.", client);
	}

	public void broadcast(String msg, ClientHandler sender) {
		for (ClientHandler member : users) {
			if (member != sender) {
				member.printMessage(ColorPrint.BLUE + ColorPrint.BOLD + msg);
			}
		}
	}

	public void sendMessage(String msg, String senderNickname) {
		for (ClientHandler member : users) {
			if (member.getNickname().equals(senderNickname)) {
				// 자기 자신에게는 (나)로 표시 + 파란색
				member.printMessage(ColorPrint.GRAY + "(나): " + msg);
			} else {
				// 다른 사람에게는 원래 닉네임으로 표시
				member.printMessage(senderNickname + ": " + msg);
			}
		}
	}

	public int getUserCount() {
		return users.size();
	}

	public ClientHandler getMember(String client) {
		for (ClientHandler member : users) {
			if (member.getNickname().equals(client)) {
				return member;
			}
		}
		return null;
	}

}