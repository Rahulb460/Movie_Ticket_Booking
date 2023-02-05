package com.example.bookMyShowBackend.Converter;

import com.example.bookMyShowBackend.RequestDtos.MovieRequestDto;
import com.example.bookMyShowBackend.Models.MovieEntity;
import com.example.bookMyShowBackend.ResponseDtos.MovieResponseDto;

public class MovieConverter {

    public static MovieEntity convertDtoToEntity(MovieRequestDto movieRequestDto){
        MovieEntity movieEntity = MovieEntity.builder().movieName(movieRequestDto.getName()).
                duration(movieRequestDto.getDuration()).releaseDate(movieRequestDto.getReleaseDate()).build();

        return movieEntity;
    }

    public static MovieResponseDto convertEntityToDto(MovieEntity movie){
        MovieResponseDto movieResponseDto = MovieResponseDto.builder().movieName(movie.getMovieName()).
                duration(movie.getDuration()).
                releaseDate(movie.getReleaseDate()).
                showList(ShowConverter.convertEntityToDto(movie)).build();

        return movieResponseDto;
    }
}
