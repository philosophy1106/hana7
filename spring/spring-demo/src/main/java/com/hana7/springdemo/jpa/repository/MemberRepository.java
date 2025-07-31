package com.hana7.springdemo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.hana7.springdemo.jpa.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>, QuerydslPredicateExecutor<Member> {
	@Modifying
	@Transactional
	@Query("delete from Member where id = :id") //쿼리가 직접 날라가기 때문에 CascadeType.ALL 모름?
	int removeById(@Param("id") long id);
}