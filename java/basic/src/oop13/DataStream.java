package oop13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import bank.Account;

public class DataStream {
	static final Account[] accounts = {
		new Account("11111", "Conan", 300000),
		new Account("22222", "Rose", 200000),
		new Account("33333", "Miran", 100000),
	};

	public static void main(String[] args) throws IOException {
		Account acc = accounts[0];
		System.out.println("acc = " + acc);

		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("C:/Users/lah27/Desktop/test.txt"))) {
			dos.writeUTF(acc.getAccountNo());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		try (DataInputStream dis = new DataInputStream(new FileInputStream("C:/Users/lah27/Desktop/test.txt"))) {
			Account acc2 = new Account(dis.readUTF(), dis.readUTF(), dis.readInt());
			System.out.println("acc2 = " + acc2);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}