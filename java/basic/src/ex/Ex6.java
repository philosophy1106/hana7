package ex;

import java.util.Scanner;

class Goods {
	final String name;
	final int price;
	final int stock;
	final int sold;

	public Goods(String name, int price, int stock, int sold) {
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.sold = sold;
	}

	public Goods(String... str) {
		this(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]), Integer.parseInt(str[3]));
	}

	public static void main(String[] args) {
		Goods[] goods = new Goods[100];
		int goodsIndex = 0;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("상품명, 가격, 재고, 판매량을 입력하시오 ");
			String inputStr = sc.nextLine();
			if (inputStr.isBlank()) {
				break;
			}
			String[] data = inputStr.split("\\s+");
			goods[goodsIndex++] = new Goods(data);
		}

		System.out.println("상품명 가격 재고량 판매량");
		for (Goods good : goods) {
			if (good == null) {
				break;
			}
			System.out.printf("%7s %,5d %3d %3d%n", good.name, good.price, good.stock, good.sold);
		}
	}
}