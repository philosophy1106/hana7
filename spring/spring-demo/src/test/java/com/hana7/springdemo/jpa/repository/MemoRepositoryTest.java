package com.hana7.springdemo.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.StringUtils;

import com.hana7.springdemo.jpa.entity.Memo;
import com.hana7.springdemo.jpa.entity.QMemo;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

//@SpringBootTest
@Rollback(false)
public class MemoRepositoryTest extends RepositoryTest {
	@Autowired
	MemoRepository memoRepository;

	@Test
	@Order(1)
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
	@Test
	@Commit
	@Order(2)
	void add100Test(){
		List<Memo> list= Stream.iterate(1, n -> n + 1).limit(100)
			.map(n->Memo.builder().memoText("Text" + n).build())
			.toList();

		memoRepository.saveAll(list);
		assertEquals(100, memoRepository.count());
	}
	@Test
	@Order(3)
	void pagingTest(){
		Sort sorting = Sort.by(Sort.Order.desc("mno"));
		Page<Memo> p1 = memoRepository.findAll(getPageable(1, sorting));
		p1.stream().forEach(this::print);

		memoRepository.findAll(getPageable(2, sorting))
			.stream().forEach(this::print);
	}

	@Test
	@Order(4)
	@Commit
	void deleteTest() {
		memoRepository.deleteById(100);
		assertFalse(memoRepository.findById(100).isPresent());

		memoRepository.deleteByMnoBetween(81, 90);
		assertEquals(89, memoRepository.count());

		long removeCnt = memoRepository.removeByMnoBetween(91, 100);
		System.out.println("removeCnt = " + removeCnt);
		assertEquals(80, memoRepository.count());
	}

	@Test
	@Order(5)
	void queryAnnotationTest() {
		List<Memo> list = memoRepository.getListOverDesc(70);
		list.forEach(this::print);

		List<Object[]> listSome = memoRepository.getListSomeDesc();
		for(Object[] objs : listSome) {
			System.out.println(Arrays.toString(objs));
		}
	}

	@Test
	@Order(6)
	void queryDslTest() {
		Iterable<Memo> memo5s = memoRepository.findAll(QMemo.memo.memoText.contains("5"));
		memo5s.forEach(this::print);

		memoRepository.findAll(
				QMemo.memo.mno.goe(60)
					.and(QMemo.memo.memoText.contains("5")))
			.forEach(this::print);

		BooleanBuilder bb = new BooleanBuilder();
		// BooleanExpression over60 = QMemo.memo.mno.goe(60);
		BooleanExpression over60 = getBoolExp(0);
		bb.and(over60).and(getContainsText("5"));
		memoRepository.findAll(bb).forEach(this::print);
	}

	private BooleanExpression getBoolExp(int mno) {
		if (mno > 0)
			return QMemo.memo.mno.goe(mno);

		return null;
	}

	private BooleanExpression getContainsText(String txt) {
		if (StringUtils.hasText(txt))
			return QMemo.memo.memoText.contains(txt);

		return null;
	}


	private static Pageable getPageable(int pageNo, Sort sorting){
		return PageRequest.of(pageNo + 1, 10, sorting);
	}

	private void print(Memo memo) {
		System.out.println(memo);
	}

}