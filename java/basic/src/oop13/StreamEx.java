package oop13;

import java.io.IOException;
import java.io.PrintStream;

public class StreamEx {
	public static void main(String[] args) throws IOException {
		byte[] buf = new byte[] {95, 96, 97};
		PrintStream out = System.out;
		out.println("PrintLn");
		out.write(65);
		out.write('\n');
		out.write(buf);

		int b = 0;
		int len = 0;

	}
}