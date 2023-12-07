package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.entity.Movies;

public interface MoviesRepository extends JpaRepository<Movies,Integer> {

}
