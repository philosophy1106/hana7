package com.hana7.springdemo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.hana7.springdemo.dto.User;

@Repository
@Mapper
public interface UserDAO {
	 User getUser(int id);
	 void insert(User user);
	 void update(User user);
	 void delete(int id);
	 List<User> getUsers();
}