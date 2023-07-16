package com.app.blog.services;

import java.util.List;

import com.app.blog.payloads.CategoryDto;

public interface CategoryService {
	
	//create
	CategoryDto createCategory(CategoryDto cDto);
	
	//update
	CategoryDto updateCategory(Integer categoryId, CategoryDto cDto);
	
	//delete
	void deleteCategory(Integer categoryId);
	
	//get
	CategoryDto getCategory(Integer categoryId);
	
	//get all
	List<CategoryDto> getAllCategories();

}
