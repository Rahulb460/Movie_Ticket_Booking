package com.example.bookMyShowBackend.Controllers;

import com.example.bookMyShowBackend.RequestDtos.MovieRequestDto;
import com.example.bookMyShowBackend.ResponseDtos.MovieResponseDto;
import com.example.bookMyShowBackend.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    // Add a movie
    @PostMapping("/add")
    public ResponseEntity<String> addMovie(@RequestBody() MovieRequestDto movieRequestDto) throws Exception {
        String response = movieService.addMovie(movieRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    //Get movie by Name
    @GetMapping("/get_movie")
    public ResponseEntity<MovieResponseDto> getMovieByName(@RequestParam String movieName){
        MovieResponseDto movieResponseDto = movieService.getMovieByName(movieName);
        return new ResponseEntity<>(movieResponseDto, HttpStatus.FOUND);
    }


    // Get all movies
    @GetMapping("/get_all")
    public ResponseEntity<List<MovieResponseDto>> getAllMovies(){
        List<MovieResponseDto> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.FOUND);
    }

}
