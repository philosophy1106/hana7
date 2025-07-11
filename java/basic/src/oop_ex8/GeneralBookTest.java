package oop_ex8;

public class GeneralBookTest {
	public static void main(String[] args) {
		String[] names = {"Sam", "Rhee", "Kim"};
		String[] records = {"1111", "2222", "3333"};
		ArrayedGeneralBook gb = new ArrayedGeneralBook(names, records);
		System.out.println(gb.names()); //Sam Rhee Kim
		gb.add("Allan", "4444");
		gb.print();
		//Allan4444\nKim3333\nRhee2222\nSam1111
		//System.out.println("현재 저장된 데이터의 크기 : " + gb.size(names)); //4
		gb.add("Alex", "5555");
		//System.out.println("현재 저장된 데이터의 크기 : " + gb.size(names)); //5
		gb.print(); //Alex5555\nAllan4444\nKim3333\nRhee2222\nSam1111\n
		System.out.println(gb.nameExists("Alex")); //true
		gb.remove("Alex", "5555");
		gb.print();
		gb.remove("Sam", "1111");
		gb.print(); //Allan4444\nKim3333\nRhee2222
		String foundRecord = gb.get("Allan");
		System.out.println(foundRecord); //4444
	}
}