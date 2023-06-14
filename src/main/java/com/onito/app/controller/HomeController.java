package com.onito.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.onito.app.module.Movies;
import com.onito.app.module.Ratings;
import com.onito.app.servicei.HomeServiceI;

@RestController
@RequestMapping("/v1")
public class HomeController {
 @Autowired
private HomeServiceI hs;
 
 @PostMapping("/api/new-movie")

 public String createMovies(@RequestBody Ratings mm){
	 System.out.println("succes");
	return hs.savemovie(mm);
	 
 }
 @GetMapping("/api/longest-duration-movies")
 public List<Movies> getLongestDurationTime(){
	return hs.getAllMovies();
	 
 }
 @GetMapping("/api/top-rated-movies")
 public List<Ratings> gettopratedmovies(){
	 return hs.getRatings();
 }
 @GetMapping("/api/genre-movies-with-subtotals")
 public List<Ratings> genremovieswithsubtotals(){
	 return hs.getsubtotals();
 }
@PostMapping("/update-runtime-minutes")
public ResponseEntity<String> updateRuntimeMinutes() {
    hs.updateRuntimeMinutes();
    return ResponseEntity.ok("Runtime minutes updated successfully.");
}
 
 
}
