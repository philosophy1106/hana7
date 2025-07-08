package bank;

import java.util.Scanner;

public class Account {
	String accountNo;
	String name;
	double balance;

	public Account() {
		this("11-111-111", "코난", 20000);
	}

	public Account(String name) {
		this("22-222-222", name, 100000);
	}

	public Account(String accountNo, String name, double balance) {
		this.insert(accountNo, name, balance);
	}

	public void insert(String accountNo, String name, double balance) {
		this.accountNo = accountNo;
		this.name = name;
		this.balance = balance;
	}

	public void deposit(double amount) {
		this.action(amount);
	}

	public void withdraw(double amount) {
		if (amount > this.balance) {
			System.out.println("잔액이 부족하여 출금할 수 없음!");
			return;
		}
		this.action(-amount);
	}

	//송금 (내 계좌의 잔액은 줄어들고, another의 잔액은 늘어남)
	public void transferTo(Account another, double amount) {
		System.out.printf("%s이(가) %s에게 %,.0f원 송금 시도 %n", this.name, another.name, amount);
		if (amount > this.balance) {
			System.out.println("송금액이 잔액을 초과하였습니다");
			return;
		}
		this.withdraw(amount);
		another.deposit(amount);
		this.checkBalance();
	}

	private void action(double amount) {
		this.balance += amount;
		String isDeposit = (amount > 0) ? "입금" : "출금";
		System.out.printf("%s님 %,.0f원이 %s되었습니다 %n", this.name, Math.abs(amount), isDeposit);
	}

	public void checkBalance() {
		System.out.printf("%s 님의 잔액은 %,.0f원 입니다.%n", this.name, this.balance);
	}

	public void display() {
		System.out.println(this);
	}

	public static void displayAll(Account[] accounts) {
		for (Account account : accounts) {
			account.display();
		}
	}

	public static int findUser(Account[] accounts, String accountNo) {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i].accountNo.equals(accountNo)) {
				return i;
			}
		}
		return -1;
	}

	public static boolean isInvalidAccount(int userNo) {
		if (userNo < 0) {
			System.out.println("존재하지 않는 계좌입니다 다시 입력해 주세요");
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "bank.Account[" + "accountNo=" + accountNo + ", name=" + name + '\'' + ", balance=" + balance + ']';
	}

	@SuppressWarnings("checkstyle:WhitespaceAround")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Account[] accounts = new Account[3];
		accounts[0] = new Account();
		accounts[1] = new Account("장미");
		accounts[2] = new Account("33-333-333", "미란", 500000);

		System.out.println("초기 계좌 정보");
		displayAll(accounts);

		while (true) {
			//1. 어떤 손님이 은행 업무 중인지 선택
			System.out.println("사용자의 계좌를 입력해 주세요");
			String accountNo = sc.nextLine();
			int userNo = findUser(accounts, accountNo);
			if (isInvalidAccount(userNo)) {
				continue;
			}
			//2. 어떤 은행 업무를 할 건지 선택
			System.out.println("+: 입금, -: 출금, >: 송금 Q/Enter: 종료 ");
			String action = sc.nextLine();
			if (action.isBlank() || "Q".equalsIgnoreCase(action)) {
				System.out.println("작업이 완료되었습니다");
				break;
			}
			//2. 입/출금/송금 세 가지 케이스
			if (action.equals("+") || action.equals("-")) {
				boolean isDeposit = "+".equals(action);
				String actionText = isDeposit ? "입금" : "출금";
				System.out.printf("%s할 금액을 입력하시오 %n", actionText);

				double amount = sc.nextDouble();
				if (isDeposit) {
					accounts[userNo].deposit(amount);
				} else {
					accounts[userNo].withdraw(amount);
				}
				sc.nextLine();
			} else if (action.equals(">")) {
				System.out.println("송금할 계좌 번호와 금액을 입력하세요");
				String str = sc.nextLine();
				String[] param = str.split("\\s+");

				String another = param[0];
				int amount = Integer.parseInt(param[1]);

				int anotherNo = findUser(accounts, another);
				if (isInvalidAccount(anotherNo)) {
					continue;
				}
				accounts[userNo].transferTo(accounts[anotherNo], amount);
			} else {
				System.out.println("잘못된 입력입니다 다시 선택해 주세요");
			}
		}
		System.out.println("은행 업무 이후 계좌 정보");
		displayAll(accounts);
	}
}