package com.onito.app.dto;

import com.onito.app.module.Movies;
import com.tejasvi.blog.payloads.CategoryDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingsDto {
	private String tconst;
	private double averageRating;
	private Movies movies;
}
