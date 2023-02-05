package com.example.bookMyShowBackend.Service;

import com.example.bookMyShowBackend.RequestDtos.MovieRequestDto;
import com.example.bookMyShowBackend.Models.MovieEntity;
import com.example.bookMyShowBackend.Converter.MovieConverter;
import com.example.bookMyShowBackend.Repository.MovieRepository;
import com.example.bookMyShowBackend.Repository.ShowRepository;
import com.example.bookMyShowBackend.ResponseDtos.MovieResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    private ShowRepository showRepository;

    public String addMovie(MovieRequestDto movieRequestDto){

        //Convert Dto to Entity layer for saving it to the Database.
        try {
            MovieEntity movie = MovieConverter.convertDtoToEntity(movieRequestDto);
            movieRepository.save(movie);
        }
        catch (Exception e){
            throw new RuntimeException("Not able to add requested movie!!");
        }
        return "Movie added Successfully!";
    }

    public MovieResponseDto getMovieByName(String name){
        try {
            MovieEntity movie = movieRepository.findByMovieName(name);
            MovieResponseDto movieResponseDto = MovieConverter.convertEntityToDto(movie);
            return movieResponseDto;
        }
        catch (Exception e){
            throw new RuntimeException("Requested Movie does not exist in Database!!");
        }
    }

    public List<MovieResponseDto> getAllMovies() {
        try {
            List<MovieEntity> movies = movieRepository.findAll();
            List<MovieResponseDto> dtoList = new ArrayList<>();

            for(MovieEntity movie : movies){
                MovieResponseDto movieResponseDto = MovieConverter.convertEntityToDto(movie);
                dtoList.add(movieResponseDto);
            }
            return dtoList;
        }
        catch (Exception e){
            throw new RuntimeException("No Movies exist in Database!!");
        }
    }
}
