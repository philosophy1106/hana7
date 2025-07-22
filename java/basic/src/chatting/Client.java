package chatting;

import java.io.IOException;
import java.net.Socket;

public class Client {
	public static final int PORT = 9999;

	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("localhost", PORT);
		Thread sendThread = new Thread(new SenderThread(socket));
		Thread receiveThread = new Thread(new ReceiverThread(socket));
		System.out.println("====클라이언트 접속====");
		try {
			//채팅 보내는 쓰레드
			sendThread.start();
			//채팅 받는 쓰레드
			receiveThread.start();
		} catch (Exception e) {
			System.out.println("서버와 연결이 끊어졌습니다");
		}
	}
}