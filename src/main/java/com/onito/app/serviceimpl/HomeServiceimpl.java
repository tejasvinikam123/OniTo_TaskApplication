package com.onito.app.serviceimpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onito.app.module.Movies;
import com.onito.app.module.Ratings;
import com.onito.app.repository.HomeRepository;
import com.onito.app.repository.RatingRepository;
import com.onito.app.servicei.HomeServiceI;

import jakarta.transaction.Transactional;

@Service
public class HomeServiceimpl implements HomeServiceI {

@Autowired
RatingRepository rr;
@Autowired
HomeRepository hr;

	@Override
	public String savemovie(Ratings mm) {
		rr.save(mm);
		
			
		return "Succesfully saved";
	}

	@Override
	public List<Movies> getAllMovies() {
		
		 
		  List<Movies> movies =  hr.findAll();
		  List<Movies> sortedMovies = movies.stream()
                 .sorted(Comparator.comparingInt(Movies::getRuntimeMinutes).reversed())
                 .collect(Collectors.toList());
		return sortedMovies;
	}

	@Override
	public List<Ratings> getRatings() {
		List<Ratings> movies = 	rr.findAll();
		// Filter movies with average rating greater than 6.0
       List<Ratings> filteredMovies = movies.stream()
               .filter(movie -> movie.getAverageRating() > 6.0)
                .collect(Collectors.toList());

       //  Sort movies by average rating in ascending order
       
       List<Ratings> l=new ArrayList();
       Movies m=new Movies();
       Ratings rrr=new Ratings();
       for(Ratings r:filteredMovies) {
    	   rrr.setTconst(r.getTconst());
    	   rrr.setAverageRating(r.getAverageRating());
    	  
    	   m.setPrimaryTitle(r.getMovies().getPrimaryTitle());
    	   m.setGenres(r.getMovies().getGenres());
    	   rrr.setMovies(m);
    	   l.add(rrr);
       }
        List<Ratings> sortedMovies = l.stream()
               .sorted(Comparator.comparingDouble(Ratings::getAverageRating))
                .collect(Collectors.toList());

        return sortedMovies;
	
	}

	@Override
	@Transactional
	public List<Ratings> getsubtotals() {
		return rr.getsubtotalofeachgener();
	}

	@Override
	@Transactional
	public void updateRuntimeMinutes() {
	   rr.updateRuntimeMinutes();
	    }
		
	}


