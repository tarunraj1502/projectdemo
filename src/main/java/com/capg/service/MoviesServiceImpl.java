package com.capg.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.entity.Movies;
import com.capg.exception.MovieIdNotFoundException;
import com.capg.repository.MoviesRepository;
import com.capg.utility.AppConstant;

@Service
public class MoviesServiceImpl implements MoviesService {

	@Autowired
	MoviesRepository moviesRepository;
	
	@Override
	public Movies addMovie(Movies movies) {
		
		 return moviesRepository.save(movies);
	 }
	 
	 @Override
	 public List<Movies> getAllMovies(){
		 return moviesRepository.findAll();
	 }
	 
	 @Override
		public String deleteMovieById(int id) {
			
			String msg;
			if(moviesRepository.existsById(id))
			{
				moviesRepository.deleteById(id);
				msg="movie successfully deleted";
			}
			else
			{
				throw new MovieIdNotFoundException(AppConstant.MOVIE_ID_NOT_FOUND_INFO);
			}
			
			return msg;
		}
}
