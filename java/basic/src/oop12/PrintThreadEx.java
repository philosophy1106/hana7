package oop12;

import lombok.AllArgsConstructor;

class PrintTable {
	//synchronized 추가하면 경합 X
	public synchronized void printTable(int n) {
		System.out.println(n + "단 출력");
		for (int i = 1; i < 10; i++) {
			System.out.println(n + " * " + i + " = " + n * i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}

@AllArgsConstructor
class PrintThread extends Thread {
	private PrintTable pt;
	private int num;

	public void run() {
		pt.printTable(num);
	}
}

public class PrintThreadEx {
	public static void main(String[] args) {
		PrintTable pt = new PrintTable();
		PrintThread t1 = new PrintThread(pt, 2);
		PrintThread t2 = new PrintThread(pt, 3);
		t1.start();
		t2.start();
	}
}