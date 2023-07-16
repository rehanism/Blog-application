package com.app.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.blog.payloads.ApiResponse;
import com.app.blog.payloads.PostDto;
import com.app.blog.services.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {
	
	@Autowired
	private PostService service;
	
	//create
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,
			@PathVariable("userId") Integer userId, @PathVariable("categoryId") Integer categoryId)
	{
		PostDto creatPost = this.service.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(creatPost, HttpStatus.CREATED);
	}
	
	//getting post by user
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable ("userId") Integer userId)
	{
		List<PostDto> posts = this.service.getPostByUser(userId);
		return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
	}
	
	//getting post by category
		@GetMapping("/category/{categoryId}/posts")
		public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable ("categoryId") Integer categoryId)
		{
			List<PostDto> posts = this.service.getAllPostByCategory(categoryId);
			return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
		}
		
		//get all post
		@GetMapping("/posts")
		public ResponseEntity<List<PostDto>> getAllPost(
				@RequestParam(value="pageNumber", defaultValue="1", required=false) Integer pageNumber,
				@RequestParam(value="pageSize", defaultValue="5", required=false) Integer pageSize)
		{
			List<PostDto> posts = this.service.getAllPost(pageNumber, pageSize);
			return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
		}
		
		//get post by id
		@GetMapping("/posts/{postId}")
		public ResponseEntity<PostDto> getPostById(@PathVariable("postId") Integer postId)
		{
			PostDto posts = this.service.getPostById(postId);
			return new ResponseEntity<PostDto>(posts, HttpStatus.OK);
		}
		
		//delete post
		@DeleteMapping("/posts/{postId}")
		public ApiResponse deletePost(@PathVariable("postId") Integer postId)
		{
			this.service.deletePost(postId);
			return new ApiResponse("category is deleted successfully", true);

		}
		
		//update
		@PutMapping("/posts/{postId}")
		public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,
				@PathVariable("categoryId") Integer postId)
		{
			PostDto updatePost = this.service.updatePost(postDto, postId);
			return new ResponseEntity<PostDto>(updatePost, HttpStatus.OK);
		}

}
