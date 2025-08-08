package com.hana7.springdemo;

import static org.junit.jupiter.api.Assertions.*;

import java.text.MessageFormat;
import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

@SpringBootTest
public class MessageTest {
	@Autowired
	MessageSource msgsrc;

	@Test
	void messageTest() {
		System.out.println("Locale.getDefault() = " + Locale.getDefault());
		String siteName = msgsrc.getMessage("site.title", null, Locale.getDefault());
		assertEquals("데모앱", siteName);

		assertThrows(NoSuchMessageException.class, () -> msgsrc.getMessage("site.titleXX", null, Locale.KOREA));

		String msg = msgsrc.getMessage("site.description", new Object[] {"하나로7기"}, Locale.getDefault());
		assertEquals("데모::하나로7기", msg);

		String msgEn = msgsrc.getMessage("site.description", new Object[] {"Hanaro7"}, Locale.ENGLISH);
		assertEquals("DEMO::Hanaro7", msgEn);

		String fullMsg = MessageFormat.format("한글로는 {0}, {1} in English", msg, msgEn);
		assertEquals("한글로는 데모::하나로7기, DEMO::Hanaro7 in English", fullMsg);
	}
}