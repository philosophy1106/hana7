package oop12;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DeamonThread extends Thread {

	@Override
	public void run() {
		System.out.println("DaemonThread started!!");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println("DaemonThread ended!!");
	}

	public static void main(String[] args) {
		System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());

		DeamonThread dt = new DeamonThread();
		// dt.setDaemon(true);
		dt.start();

		System.out.println("Main thread ended!!");
	}
}