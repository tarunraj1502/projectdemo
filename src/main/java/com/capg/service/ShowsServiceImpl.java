package com.capg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.dto.ShowDto;
import com.capg.entity.Hall;
import com.capg.entity.Movies;
import com.capg.entity.Shows;
import com.capg.exception.ShowIdNotFoundException;
import com.capg.repository.HallRepository;
import com.capg.repository.MoviesRepository;
import com.capg.repository.ShowsRepository;
import com.capg.utility.AppConstant;

 @Service
public class ShowsServiceImpl implements ShowsService{

	@Autowired
	private ShowsRepository showsRepository; 
	@Autowired
	private HallRepository hallRepository;
	@Autowired
	private MoviesRepository moviesRepository;
	
	public List<Shows> getListOfShows(){ 
	
		return showsRepository.findAll();
	}
	public Shows addShows(Shows show) {
//		CrudRepository<Shows, Integer> hallRepository;
		Hall hall=hallRepository.findById(show.getHall().getHallId()).get();
//		showsRepository.save(show);
				show.setHall(hall);
		return showsRepository.save(show);
	}
	@Override
	 public String deleteShowsById(int id) {
		 String msg;
			if(showsRepository.existsById(id))
			
				showsRepository.deleteById(id);
				msg="Shows successfully deleted";
			
//			else
//			{
//				throw new HallIdNotFoundException(AppConstant.HALL_ID_NOT_FOUND_INFO);
//			}
			
			return msg;
		}
	 
	 @Override
		public Shows updateShowById(int id, Shows shows) {
			
		// Shows updatedShows=null;
			
			if(showsRepository.existsById(id))
			shows.setShowId(id);
			   
			   //			 }
//			else
//			{
//				throw new ShowsIdNotFoundException(AppConstant.HALL_ID_NOT_FOUND_INFO);
//			}
//			
			return showsRepository.save(shows);
		}
	 public Shows addShows2(ShowDto showDto) {
			Shows shows= new Shows();
			System.out.println(showDto);
			Hall hall=hallRepository.findById(showDto.getHallId()).get();
			Movies movies=moviesRepository.findById(showDto.getMovieId()).get();
			
			shows.setMovies(movies);
			shows.setHall(hall);
			shows.setSlotNo(showDto.getSlotNo());
			shows.setToDate(showDto.getToDate());
			shows.setFromDate(showDto.getFromDate());

			return showsRepository.save(shows);
		}
	 @Override
		public Shows getShowById(int id) {
		   Optional<Shows> optionalShows=showsRepository.findById(id);
		   
		   if(optionalShows.isEmpty())
		   {
			   throw new ShowIdNotFoundException(AppConstant.SHOW_ID_NOT_FOUND_INFO);
		   }
		   
		       return optionalShows.get();
		}
}
