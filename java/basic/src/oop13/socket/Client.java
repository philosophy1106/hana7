package oop13.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Client {
	public static final int PORT = 9999;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
		try (Socket socket = new Socket("localhost", PORT)) {
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			while (true) {
				String msg = sc.nextLine();
				if (msg.equals("bye")) {
					break;
				}
				out.writeUTF(msg);
				System.out.println(LocalDateTime.now().format(formatter) + ">> " + msg);
			}
			in.close();
			out.close();
		} catch (Exception e) {
			System.out.println("서버와의 연결이 종료되었습니다");
		}
	}
}