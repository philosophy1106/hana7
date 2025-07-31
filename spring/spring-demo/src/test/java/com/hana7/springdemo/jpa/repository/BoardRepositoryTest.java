package com.hana7.springdemo.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import com.hana7.springdemo.jpa.entity.BloodType;
import com.hana7.springdemo.jpa.entity.Board;
import com.hana7.springdemo.jpa.entity.BoardContent;
import com.hana7.springdemo.jpa.entity.Hashtag;
import com.hana7.springdemo.jpa.entity.Member;

//@Rollback(false)
class BoardRepositoryTest extends RepositoryTest {
	@Autowired
	BoardRepository repository;

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	HashtagRepository hashtagRepository;

	private static final int LIMIT = 10;

	@Test
	@Order(1)
	void addTest() {
		long preCount = repository.count();

		List<Board> list = Stream.iterate(1, n -> n + 1)
			.limit(LIMIT)
			.map(n -> Board.builder()
				.title("Title" + n)
				.writer(getMember())
				// .content(new BoardContent("Content" + n))
				.build())
			.toList();

		list.forEach(b -> b.setContent(new BoardContent("xxx", b)));

		repository.saveAll(list);

		// List<BoardContent> contents = list.stream()
		// 	.map(b -> new BoardContent("Content", b)).toList();
		// contentRepository.saveAll(contents);

		assertEquals(preCount + LIMIT, repository.count());
	}

	@Test
	@Order(2)
	void pageListTest() {
		repository.findAll(
			PageRequest.of(0, 10, Sort.by(Sort.Order.desc("id"))))
			.forEach(this::print);
	}

	private Member getMember() {
		Optional<Member> member = memberRepository.findById(1L);
		return member.orElseGet(() -> memberRepository.save(
			Member.builder()
				.nickname("Hongxxx")
				.email("hongxxx@gamil.com")
				.bloodType(BloodType.B)
				.build())
		);
	}

	@Test
	@Order(3)
	@Commit
	void hashtagTest() {
		Hashtag hi = hashtagRepository.save(Hashtag.builder()
			.tag("hi").build());

		Hashtag hello = hashtagRepository.save(Hashtag.builder()
			.tag("hello").build());

		Board board1 = repository.findById(1).orElseThrow();
		Board board2 = repository.findById(2).orElseThrow();

		hi.addBoard(board1);
		hi.addBoard(board2);
		hi.addBoard(board1);
		hi.addBoard(board2);

		hashtagRepository.findAllByBoardId(board1.getId()).forEach(this::print);

	}
}