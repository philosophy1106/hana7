package bank;

public enum Action {
	입금("+") {
		@Override
		public void banking(Account account, int amount) {
			account.deposit(amount);
		}
	}, 출금("-") {
		@Override
		public void banking(Account account, int amount) {
			account.withdraw(amount);
		}
	}, 송금(">") {
		@Override
		public void banking(Account account, int amount) {
			account.transferTo(amount);
		}
	}, 조회("*") {
		@Override
		public void banking(Account account, int amount) {
			account.display();
		}
	}, 종료("Q") {
		@Override
		public void banking(Account account, int amount) {
			System.out.println("작업이 종료되었습니다");
		}
	};
	private final String cmd;

	Action(String cmd) {
		this.cmd = cmd;
	}

	public boolean isMe(String cmd) {
		return this.cmd.equals(cmd);
	}

	public abstract void banking(Account account, int amount);
}