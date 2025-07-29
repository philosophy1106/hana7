package com.hana7.springdemo.jpa.repository;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hana7.springdemo.jpa.entity.Board;

class ReplyRepositoryTest extends RepositoryTest {
	@Autowired
	ReplyRepository repository;

	@Autowired
	BoardRepository boardRepository;

	@Test
	@Order(1)
	void addTest() {
		Board board = getBoard();
	}

	@Test
	@Order(2)
	void listTest() {

	}

	@Test
	@Order(3)
	void updateTest() {

	}

	@Test
	@Order(4)
	void deleteTest() {

	}


	private Board getBoard() {
		return boardRepository.findById(1).orElseThrow();
	}
}