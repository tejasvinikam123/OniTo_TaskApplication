package com.onito.app.dto;

import com.tejasvi.blog.payloads.CategoryDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoviesDto {
	private String tconst;
	private String primaryTitle;
	private String genres;
}
