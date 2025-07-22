package oop13;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NsLookup {
	public static void main(String[] args) throws UnknownHostException {
		String url = "https://www.naver.com/afd=asdsfasdf=1";
		String domain = url.replaceAll("https?://([^/]+).*", "$1");
		System.out.println("Domain: " + domain);
		InetAddress[] ias = InetAddress.getAllByName(domain);
		for (InetAddress ia : ias) {
			System.out.println("Hostname: " + ia.getHostName());
			System.out.println("HostAddress: " + ia.getHostAddress());
		}
	}
}