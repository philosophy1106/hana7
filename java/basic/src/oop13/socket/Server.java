package oop13.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static final int PORT = 9999;

	public static void main(String[] args) throws IOException {
		try (ServerSocket server = new ServerSocket(PORT)) {
			Socket client = server.accept(); //한 명만 accept 받고 계속 while 돌고 있는 것
			
			DataInputStream in = new DataInputStream(client.getInputStream());
			DataOutputStream out = new DataOutputStream(client.getOutputStream());
			System.out.println("접속을 기다립니다");
			System.out.printf("%s 로부터 접속하였습니다\n", client.getInetAddress());
			while (true) {
				String msg = in.readUTF();
				if (msg.equals("bye")) {
					break;
				}
				System.out.println("클라이언트로부터 전송받은 문자열 " + msg);
			}
			in.close();
			out.close();
		} catch (IOException e) {
			System.out.println("Server Down");
		}

	}
}