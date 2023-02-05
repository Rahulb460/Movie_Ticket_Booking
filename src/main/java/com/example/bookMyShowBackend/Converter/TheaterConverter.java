package com.example.bookMyShowBackend.Converter;

import com.example.bookMyShowBackend.Models.TheaterEntity;
import com.example.bookMyShowBackend.RequestDtos.TheaterRequestDto;
import com.example.bookMyShowBackend.ResponseDtos.TheaterResponseDto;

public class TheaterConverter {

    public static TheaterEntity convertDtoToEntity(TheaterRequestDto theaterRequestDto){
        TheaterEntity theaterEntity = TheaterEntity.builder().name(theaterRequestDto.getName()).
                city(theaterRequestDto.getCity()).
                address(theaterRequestDto.getAddress()).build();

        return theaterEntity;
    }

    public static TheaterResponseDto convertEntityToDto(TheaterEntity theater){
        TheaterResponseDto theaterResponseDto= TheaterResponseDto.builder().name(theater.getName()).
                city(theater.getCity()).address(theater.getAddress()).
                seatCount(theater.getTheaterSeatEntityList().size()).build();

        return theaterResponseDto;
    }
}
