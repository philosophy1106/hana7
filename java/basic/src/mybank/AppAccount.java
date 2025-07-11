package mybank;

public class AppAccount<T extends Account> {
	private final T account;

	public AppAccount(T account) {
		this.account = account;
	}

	public boolean isWithdrawable() {
		return this.account instanceof Withdrawable;
	}

	public int deposit(int amt) {
		var benefit = (int)(amt * 0.1);
		return this.account.deposit(amt + benefit);
	}

	public int withdraw(int amt) {
		if (!isWithdrawable()) {
			throw new IllegalStateException("cannot withdraw");
		}
		return ((Withdrawable)account).withdraw(amt);
	}

	@Override
	public String toString() {
		return "AppAccount {" + this.account.getClass().getSimpleName() + "}";
	}
}