package com.onito.app.module;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Ratings {
@Id

private String tconst;
private double averageRating;
private Long numVotes;
@OneToOne(cascade =CascadeType.ALL)
@JoinColumn(name= "movie_id")
private Movies movies;
public String getTconst() {
	return tconst;
}
public void setTconst(String tconst) {
	this.tconst = tconst;
}
public double getAverageRating() {
	return averageRating;
}
public void setAverageRating(double averageRating) {
	this.averageRating = averageRating;
}
public Long getNumVotes() {
	return numVotes;
}
public void setNumVotes(Long numVotes) {
	this.numVotes = numVotes;
}
public Movies getMovies() {
	return movies;
}
public void setMovies(Movies movies) {
	this.movies = movies;
}
@Override
public String toString() {
	return "Ratings [tconst=" + tconst + ", averageRating=" + averageRating + ", numVotes=" + numVotes + ", movies="
			+ movies + "]";
}

}