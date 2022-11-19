package com.devsuperior.uri2611;

import com.devsuperior.uri2611.dto.MovieMinDTO;
import com.devsuperior.uri2611.projections.MovieMinProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public void run(String... args) throws Exception {

		List<MovieMinProjection> list = movieRepository.search1("Action");

		List<MovieMinDTO> result = list.stream().map(x -> new MovieMinDTO(x)).collect(Collectors.toList());

		//PESQUISA SQL NORMAL
		for(MovieMinDTO dto: result){
			System.out.println(dto.getId() +" "+ dto.getName());
		}

		List<MovieMinDTO> result2 =  movieRepository.search2("Action");

		for(MovieMinDTO results: result2){
			System.out.println(results.getId() +" "+ results.getName());
		}

	}
}
