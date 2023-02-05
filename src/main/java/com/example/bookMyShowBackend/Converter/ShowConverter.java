package com.example.bookMyShowBackend.Converter;

import com.example.bookMyShowBackend.Models.MovieEntity;
import com.example.bookMyShowBackend.Models.ShowEntity;
import com.example.bookMyShowBackend.RequestDtos.ShowRequestDto;
import com.example.bookMyShowBackend.ResponseDtos.ShowResponseDto;

import java.util.ArrayList;
import java.util.List;

public class ShowConverter {
    public static ShowEntity convertDtoToEntity(ShowRequestDto showRequestDto){
        ShowEntity show = ShowEntity.builder().showDate(showRequestDto.getShowDate()).
                showTime(showRequestDto.getShowTime()).
                multiplier(showRequestDto.getMultiplier()).build();

        return show;
    }

    public static List<ShowResponseDto> convertEntityToDto(MovieEntity movie){
        List<ShowEntity> showList = movie.getListOfShows();
        List<ShowResponseDto> dtoList = new ArrayList<>();
        for(ShowEntity show : showList) {
            ShowResponseDto showResponseDto = ShowResponseDto.builder().showTime(show.getShowTime()).
                    showDate(show.getShowDate()).
                    showId(show.getId()).
                    theatreName(show.getTheater().getName()).
                    theatreAddress(show.getTheater().getAddress()).build();
            dtoList.add(showResponseDto);
        }
        return dtoList;
    }

    public static ShowResponseDto convertEntityToDto(ShowEntity show){
        ShowResponseDto showResponseDto = ShowResponseDto.builder().showDate(show.getShowDate()).
                showTime(show.getShowTime()).
                showId(show.getId()).
                theatreName(show.getTheater().getName()).
                theatreAddress(show.getTheater().getAddress()).build();

        return showResponseDto;
    }
}
