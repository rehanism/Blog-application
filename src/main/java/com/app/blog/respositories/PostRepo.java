package com.app.blog.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.blog.entities.Category;
import com.app.blog.entities.Post;
import com.app.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{

	List<Post> findByCategory(Category cat);

	List<Post> findByUser(User user);
	
	

}
