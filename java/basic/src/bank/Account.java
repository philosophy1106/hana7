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

	public String getAccountNo() {
		return accountNo;
	}

	public void insert(String accountNo, String name, double balance) {
		this.accountNo = accountNo;
		this.name = name;
		this.balance = balance;
	}

	public void deposit(int amount) {
		this.action(amount);
	}

	public void withdraw(int amount) {
		this.withdraw(amount, Action.출금);
	}

	public void withdraw(int amount, Action action) {
		if (amount > this.balance) {
			System.out.println(action + "액이 부족합니다!");
			return;
		}
		this.action(-amount);
	}

	//객체 지향 프로그래밍 위해 인자로 수신인 받지 않음
	private Account targetAccount;

	public void setTargetAccount(Account targetAccount) {
		this.targetAccount = targetAccount;
	}

	public void transferTo(int amount) {
		this.transferTo((this.targetAccount), amount);
	}

	//송금 (내 계좌의 잔액은 줄어들고, another의 잔액은 늘어남)
	public void transferTo(Account targetAccount, int amount) {
		if (amount > this.balance) {
			System.out.println("송금액이 잔액을 초과하였습니다");
			return;
		}
		this.withdraw(amount, Action.송금);
		targetAccount.deposit(amount);
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

	public static Account findByAccountNo(Account[] accounts, String accountNo) {
		Account account = null;
		for (Account acc : accounts) {
			if (acc.getAccountNo().equals(accountNo)) {
				account = acc;
			}
		}
		return account;
	}

	public static boolean isInvalidAccount(Account account) {
		if (account == null) {
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
			//어떤 은행 업무를 할 건지 선택
			System.out.println("+: 입금, -: 출금, >: 송금 Q/Enter: 종료 ");
			Action action = null;
			String cmd = sc.next();
			for (Action act : Action.values()) {
				if (act.isMe(cmd)) {
					action = act;
				}
			}
			if (action == Action.종료) {
				break;
			}
			if (action == null) {
				System.out.println("잘못된 입력입니다");
				continue;
			}
			System.out.println(action + "할 계좌를 선택하세요");
			System.out.print("계좌번호> ");
			String accountNo = sc.next();
			Account targetAccount = Account.findByAccountNo(accounts, accountNo);
			if (isInvalidAccount(targetAccount)) {
				continue;
			}

			//2. 입/출금/송금 세 가지 케이스
			if (action == Action.송금) {
				while (true) {
					System.out.print("출금할 계좌는> ");
					String acc = sc.next();
					if (acc.equals(targetAccount.getAccountNo())) {
						System.out.println("송금할 계좌와 출금할 계좌가 같을 수 없습니다!");
					} else {
						targetAccount.setTargetAccount(findByAccountNo(accounts, acc));
						isInvalidAccount(targetAccount);
						break;
					}
				}

			}
			if (action == Action.조회) {
				action.banking(targetAccount, 0);
			} else {
				System.out.print("얼마를 " + action + "하시겠어요? ");
				action.banking(targetAccount, sc.nextInt());
			}
		}
		System.out.println("은행 업무 이후 계좌 정보");
		displayAll(accounts);
	}
}