package com.app.blog.payloads;



import java.util.Date;

import com.app.blog.entities.Category;
import com.app.blog.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class PostDto {
	
	private Integer id;
	
	private String title;
	
	
	private String content;
	
	private String imageName;
	
	private Date addedDate;
	
	private CategoryDto category;
	
	private UserDto user;


}
