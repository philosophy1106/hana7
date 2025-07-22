package chatting;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Server {
	private static final HashMap<String, ChatRoom> rooms = new HashMap<>();
	private static final ArrayList<ClientHandler> clients = new ArrayList<>();
	public static final int PORT = 9999;

	public static void main(String[] args) throws IOException {

		try (ServerSocket server = new ServerSocket(PORT)) {
			System.out.println("==== 서버 시작 =====");
			while (true) {
				//클라이언트가 접속함 (accept됨)
				Socket client = server.accept();
				System.out.println("client connected " + client);
				ClientHandler clientHandler = new ClientHandler(client);
				Thread thread = new Thread(clientHandler);
				clients.add(clientHandler);
				thread.start();
			}
		} catch (IOException e) {
			System.out.println("서버가 종료되었습니다");
		}

	}

	//방 목록 전송
	public static String getFormattedRoomList() {
		if (rooms.isEmpty()) {
			return "▶ 현재 참여 가능한 방이 없습니다.";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("▶ 참여 가능한 방 목록:\n");
		for (Map.Entry<String, ChatRoom> entry : rooms.entrySet()) {
			String name = entry.getKey();
			int count = entry.getValue().getUserCount();
			sb.append(" * ").append(name).append(" [").append(count).append("명]\n");
		}
		return sb.toString();
	}

	public static ChatRoom getOrCreateRoom(String roomName) {
		if (rooms.containsKey(roomName)) {
			return rooms.get(roomName);
		} else {
			// 없으면 새로 만들고 Map에 저장
			ChatRoom newRoom = new ChatRoom(roomName);
			rooms.put(roomName.trim(), newRoom);
			return newRoom;
		}
	}

}