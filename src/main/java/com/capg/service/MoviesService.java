package com.capg.service;

import java.util.List;

import com.capg.entity.Movies;

public interface MoviesService {

	Movies addMovie(Movies movies);
	List<Movies> getAllMovies();
	String  deleteMovieById(int id);
}
