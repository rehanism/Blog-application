package com.app.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.blog.entities.Category;
import com.app.blog.exceptions.ResourceNotFoundException;
import com.app.blog.payloads.CategoryDto;
import com.app.blog.respositories.CategoryRepo;
import com.app.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo repo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public CategoryDto createCategory(CategoryDto cDto) {
		// TODO Auto-generated method stub
		Category cat= this.dtoToCategory(cDto);
		
		Category savedCat = this.repo.save(cat);
		
		return this.categorytoDto(savedCat);
	}

	@Override
	public CategoryDto updateCategory(Integer categoryId, CategoryDto cDto) {
		// TODO Auto-generated method stub
		Category cat = this.repo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category", "categoryId", categoryId));
		cat.setCategoryTitle(cDto.getCategoryTitle());
		cat.setCaregoryDescription(cDto.getCaregoryDescription());
		Category updatedCategory = this.repo.save(cat);
		return this.categorytoDto(updatedCategory);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		Category cat = this.repo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category", "categoryId", categoryId));
		this.repo.delete(cat);

	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		Category cat = this.repo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category", "categoryId", categoryId));
		return this.categorytoDto(cat);
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		// TODO Auto-generated method stub
		List<Category> cats = this.repo.findAll();
		List<CategoryDto> catDto = cats.stream().map( cat -> this.categorytoDto(cat)).collect(Collectors.toList());
		return catDto;
	}
	
	public CategoryDto categorytoDto(Category category)
	{
		CategoryDto cat = this.mapper.map(category, CategoryDto.class);
		return cat;
	}
	public Category dtoToCategory(CategoryDto cDto)
	{
		Category category = this.mapper.map(cDto, Category.class);
		return category;
	}

}
