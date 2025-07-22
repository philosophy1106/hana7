package chatting;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ReceiverThread implements Runnable {
	private Socket socket;

	@Override
	public void run() {
		try {
			DataInputStream in = new DataInputStream(socket.getInputStream());
			while (true) {
				String msg = in.readUTF();
				System.out.println(msg);
			}
		} catch (IOException e) {
			System.out.println("서버와 접속이 끊어졌습니다");
		}
	}
}