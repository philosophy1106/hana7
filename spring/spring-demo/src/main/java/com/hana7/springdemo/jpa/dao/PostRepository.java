package com.hana7.springdemo.jpa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.hana7.springdemo.jpa.dto.Post;
import com.hana7.springdemo.jpa.dto.User;

@Repository
@Mapper
public interface PostRepository {
	List<Post> getPosts();
	public Post getPost(int id);
	public void insert(Post user);
	public void update(Post user);
	public void delete(int id);

	public User getUser(Post post);
	public List<User> getUsers();
}