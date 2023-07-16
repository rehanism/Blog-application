package com.app.blog.services;

import java.util.List;

import com.app.blog.entities.Post;
import com.app.blog.payloads.PostDto;

public interface PostService {
	
	//create
	PostDto createPost(PostDto postDto, Integer categoryId, Integer userId);
	
	//update
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//delete
	
	void deletePost(Integer postId);
	
	//get single post
	
	PostDto getPostById(Integer postId);
	
	//get all post

	List<PostDto> getAllPost(Integer pageNumber, Integer pageSize);
	
	//get all post by category
	
	List<PostDto> getAllPostByCategory(Integer categoryId);
	
	//get all post by user
	
	List<PostDto> getPostByUser(Integer userId);
	
	//get all post by search
	
	List<Post> getAllPostBySearch(String keyword);
}
