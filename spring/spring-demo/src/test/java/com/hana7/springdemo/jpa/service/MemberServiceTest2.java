package com.hana7.springdemo.jpa.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.hana7.springdemo.jpa.dao.MemberDAO;
import com.hana7.springdemo.jpa.entity.BloodType;
import com.hana7.springdemo.jpa.entity.Member;

public class MemberServiceTest2 {
	private static final Member member = Member.builder()
		.id(1L)
		.nickname("Hong")
		.email("hong@gmail.com")
		.bloodType(BloodType.B)
		.build();

	private final MemberDAO dao = Mockito.mock(MemberDAO.class);
	private final MemberService service = new MemberServiceImpl(dao);

	@Test
	void removeTest() {
		Mockito.when(service.remove(member.getId())).thenReturn(1);

		int affectedRowCount = service.remove(1L);
		assertEquals(1, affectedRowCount );

	}
}