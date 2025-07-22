package chatting;

public class ColorPrint {
	// ANSI 색상 코드
	public static final String RESET = "\033[0m";
	public static final String RED = "\033[31m";
	public static final String GREEN = "\033[32m";
	public static final String YELLOW = "\033[33m";
	public static final String BLUE = "\033[34m";
	public static final String PURPLE = "\033[35m";
	public static final String CYAN = "\033[36m";
	public static final String WHITE = "\033[37m";
	public static final String GRAY = "\033[90m";

	// 배경색
	public static final String BG_RED = "\033[41m";
	public static final String BG_GREEN = "\033[42m";
	public static final String BG_YELLOW = "\033[43m";

	// 스타일
	public static final String BOLD = "\033[1m";
	public static final String UNDERLINE = "\033[4m";

	public static void main(String[] args) {
		System.out.println(RED + "빨간색 텍스트" + RESET);
		System.out.println(GREEN + "초록색 텍스트" + RESET);
		System.out.println(BOLD + BLUE + "굵은 파란색" + RESET);
		System.out.println(BG_YELLOW + "노란 배경" + RESET);
	}
}