package com.hana7.springdemo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hana7.springdemo.jpa.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {
}