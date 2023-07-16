package com.app.blog.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
		
		
		private Integer categoryId;
		
		@NotBlank
		@Size(min=4, message="Category Title must be minimum od 4 characters")
		private String categoryTitle;
		
		@NotBlank
		@Size(min=10, message="Category description must be minimum of 10 characters")
		private String caregoryDescription;

	

}
