package chatting;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SenderThread implements Runnable {
	private Socket socket;

	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		try {
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			while (true) {
				String msg = sc.nextLine();
				out.writeUTF(msg);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}
}