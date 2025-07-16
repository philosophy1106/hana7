package oop12;

import java.util.Random;

public class VoteThread implements Runnable {
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		Random rand = new Random();
		String currentStr = "";
		int percentage;
		int sum = 0;
		while (true) {
			percentage = rand.nextInt(5) + 1;
			sum += percentage;
			currentStr = printStar(percentage, currentStr);
			if (sum >= 100) {
				int overflow = sum - 100;
				percentage -= overflow;
				System.out.printf("%s 개표율: 100%%(개표 증가율: %d%%)%s\n", name, percentage, currentStr);
				break;
			}
			System.out.printf("%s 개표율: %d%%(개표 증가율: %d%%)%s\n", name, sum, percentage, currentStr);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public String printStar(int percentage, String currentStr) {
		StringBuilder result = new StringBuilder();
		switch (percentage) {
			case 1:
				result.append("*");
				break;
			case 2:
				result.append("**");
				break;
			case 3:
				result.append("***");
				break;
			case 4:
				result.append("****");
				break;
			case 5:
				result.append("*****");
				break;
			default:
		}
		currentStr = currentStr + result;
		return currentStr;
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new VoteThread(), "제1지역구");
		Thread t2 = new Thread(new VoteThread(), "제2지역구");
		Thread t3 = new Thread(new VoteThread(), "제3지역구");
		t1.start();
		t2.start();
		t3.start();
	}
}