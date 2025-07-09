package oop;

public interface Alarm {
	void playMusic(String title);

	void beep();

	default void setTime(String time) {
		System.out.println("Set time to " + time);
	}

	static void main(String[] args) {
		Alarm alarm = new SmartPhone();
		alarm.playMusic("비의 랩소디");
		alarm.beep();
		alarm.setTime("12:00");
	}
}

class SmartPhone implements Alarm {
	private String phoneNumber;

	void call() {
		System.out.println("Call to " + this.phoneNumber);
	}

	@Override
	public void playMusic(String title) {
		System.out.printf("[%s] 재생", title);
	}

	@Override
	public void beep() {
		for (int i = 0; i < 3; i++) {
			System.out.println("삐이익~ \007");
			System.out.flush();
		}
	}

}