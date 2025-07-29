package com.hana7.springdemo.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hana7.springdemo.jpa.entity.Memo;

@SpringBootTest
public class MemoRepositoryTest {
	@Autowired
	private MemoRepository memoRepository;

	@Test
	void testClass() {
		Memo m = Memo.builder().memoText("TEXT...").build();
		Memo savedM = memoRepository.save(m);
		assertEquals(m, savedM);

		Memo foundMemo = memoRepository.findById(savedM.getMno()).orElseThrow();
		assertEquals(savedM, foundMemo);

		System.out.println("foundMemo = " + foundMemo);
		System.out.println("repository.getClass().getName() = " + memoRepository.getClass().getName());


		foundMemo.setMemoText("New MemoText!!");
		memoRepository.saveAndFlush(foundMemo);
		System.out.println("foundMemo = " + foundMemo);

		savedM.setMemoText("SSSS");
		memoRepository.saveAndFlush(savedM);
		System.out.println("savedM = " + savedM);

		memoRepository.deleteById(savedM.getMno());
		Optional<Memo> byId = memoRepository.findById(savedM.getMno());

		byId.ifPresent(memo -> System.out.println("byId = " + memo));
	}
}