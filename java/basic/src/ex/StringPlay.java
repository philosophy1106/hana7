package ex;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;

public class StringPlay {
	public static void main(String[] args) {
		String s = "Hello Junior Coding~ Coding";
		String s1 = s.concat("concat");
		System.out.println("s1 = " + s1);
		String s2 = s + ":concat";
		System.out.println("s2 = " + s2);

		String sb = "ABC"
			+ "DEF";
		System.out.println(sb);

		String query = "abc=123&efg=456&age=10";
		StringTokenizer st = new StringTokenizer(query, "&");
		while (st.hasMoreElements()) {
			System.out.println(st.nextToken());
		}
		Format df = new DecimalFormat("#,####.0");
		String result = df.format(12345678.19);
		System.out.println("result = " + result);

		Format sdf = new SimpleDateFormat("yyyy-MM-dd K:mm:ss");

	}
}