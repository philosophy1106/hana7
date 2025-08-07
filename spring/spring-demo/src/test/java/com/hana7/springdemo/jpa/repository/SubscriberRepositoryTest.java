package com.hana7.springdemo.jpa.repository;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hana7.springdemo.jpa.entity.Subscriber;
import com.hana7.springdemo.jpa.entity.SubscriberRole;

class SubscriberRepositoryTest extends RepositoryTest {
	@Autowired
	SubscriberRepository repository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Test
	void addTest() {
		int limit = 5;
		List<Subscriber> list = Stream.iterate(1, n -> n + 1).limit(limit)
			.map(n -> Subscriber.builder()
				.email(n + "@gmail.com")
				.nickname("sub" + n)
				.pwd("pwd" + n)
				.social(false)
				.build()
				.addRole(SubscriberRole.USER)
				.addRole(n > 3 ? SubscriberRole.ROLE_ADMIN : SubscriberRole.ROLE_MANAGER)
			).toList();

		repository.saveAll(list);
		Assertions.assertEquals(limit, repository.findAll().size());
	}
	@Test
	void readTest(){
		String email = "1@gmail.com";
		Subscriber subscriber = repository.getWithRoles(email);
		System.out.println("subscriber = " + subscriber);
		System.out.println("subscriber.roles = " + subscriber.getRoles());
		Assertions.assertEquals(email, subscriber.getEmail());
		Assertions.assertEquals(List.of(SubscriberRole.ROLE_USER, SubscriberRole.ROLE_MANAGER), subscriber.getRoles());
	}
	@Test
	void passwordEncodingTest() {
		String pwd = "pwd00";
		System.out.println("passwordEncoder.encode(pwd) = " + passwordEncoder.encode(pwd));
	}
}