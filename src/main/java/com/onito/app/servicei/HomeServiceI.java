package com.onito.app.servicei;


import java.util.List;

import com.onito.app.dto.RatingsDto;
import com.onito.app.module.Movies;
import com.onito.app.module.Ratings;


public interface HomeServiceI {

	String savemovie(Ratings mm);

	List<Movies> getAllMovies();

	List<Ratings> getRatings();

	List<Ratings> getsubtotals();

	void updateRuntimeMinutes();

	

}
