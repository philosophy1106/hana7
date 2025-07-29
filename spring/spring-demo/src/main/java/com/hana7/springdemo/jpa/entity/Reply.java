package com.hana7.springdemo.jpa.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reply extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 1000, nullable = false)
	private String reply;

	@Column(length = 30, nullable = false)
	private String replyer;

	@ManyToOne
	@JoinColumn(name = "board", foreignKey = @ForeignKey(name = "fk_Reply_board"))
	private Board board;

}