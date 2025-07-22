package oop13;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileReadEx {
	public static void main(String[] args) {
		String src = "C:/Users/lah27/Desktop/test.txt";
		String dest = "C:/Users/lah27/Desktop/copy/result.txt";
		try (
			FileInputStream fis = new FileInputStream(src);
			FileOutputStream fos = new FileOutputStream(dest)
		) {
			int c;
			while ((c = fis.read()) != -1) {
				fos.write(c);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}