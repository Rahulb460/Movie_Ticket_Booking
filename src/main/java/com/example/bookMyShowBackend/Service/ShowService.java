package com.example.bookMyShowBackend.Service;

import com.example.bookMyShowBackend.Converter.ShowConverter;
import com.example.bookMyShowBackend.RequestDtos.ShowRequestDto;
import com.example.bookMyShowBackend.Models.*;
import com.example.bookMyShowBackend.Repository.MovieRepository;
import com.example.bookMyShowBackend.Repository.ShowRepository;
import com.example.bookMyShowBackend.Repository.ShowSeatRepository;
import com.example.bookMyShowBackend.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class ShowService {


    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;


    @Autowired
    ShowSeatRepository showSeatRepository;

    @Autowired
    ShowRepository showRepository;

    public String addShow(ShowRequestDto showRequestDto){


        //Show Entity
        ShowEntity showEntity = ShowConverter.convertDtoToEntity(showRequestDto);


        //You need to get the movieRepo
        MovieEntity movieEntity = movieRepository.findByMovieName(showRequestDto.getMovieName());

        //You need to get the theater Repository

        TheaterEntity theaterEntity = theaterRepository.findById(showRequestDto.getTheaterId()).get();

        showEntity.setTheater(theaterEntity);
        showEntity.setMovie(movieEntity);

        // because we are doing a bidirectional mapping
        // optional things
        movieEntity.getListOfShows().add(showEntity);
        theaterEntity.getListOfShows().add(showEntity);


        List<ShowSeatEntity> seatEntityList = createShowSeats(theaterEntity.getTheaterSeatEntityList());

        showEntity.setListOfSeats(seatEntityList);

        //For each ShowSeat : we need to mark that to which show it belongs (foreign key will be filled )
        for(ShowSeatEntity showSeat:seatEntityList){
            showSeat.setShow(showEntity);
        }

        // showRepository.save(showEntity);  // this doesn't need to be called bcz parent save function is being called
        movieRepository.save(movieEntity);
        theaterRepository.save(theaterEntity);

        return "Show added successfully";

    }

    public List<ShowSeatEntity> createShowSeats(List<TheaterSeatEntity> theaterSeatEntityList){


        List<ShowSeatEntity> seats = new ArrayList<>();

        for(TheaterSeatEntity theaterSeat: theaterSeatEntityList){

            ShowSeatEntity showSeat = ShowSeatEntity.builder().seatNo(theaterSeat.getSeatNo()).seatType(theaterSeat.getSeatType()).build();
            seats.add(showSeat);
        }

        showSeatRepository.saveAll(seats);

        return seats;
    }
}
