package mybank;

public class MyBank {
	// private AppAccount[] accounts = ;

	public static void main(String[] args) {

		Account[] accounts = {
			new FreeAccount(10000),
			new SavingAccount(10000),
			new LoanAccount(1000000)
		};

		FreeAccount fAcc = new FreeAccount(10000);
		AppAccount<FreeAccount> appAccount = new AppAccount<>(fAcc);

		AppAccount<?>[] appAccounts = new AppAccount[accounts.length];
		for (int i = 0; i < appAccounts.length; i++) {
			appAccounts[i] = new AppAccount<>(accounts[i]);
		}
		for (AppAccount<?> acc : appAccounts) {
			System.out.println("acc = " + acc.toString());
			int balance = acc.deposit(1000);
			System.out.println("deposit = " + balance);
			try {
				System.out.println("With balance = " + acc.withdraw(2000));
			} catch (IllegalStateException ise) {
				ise.printStackTrace(System.err);

			}
		}

	}
}