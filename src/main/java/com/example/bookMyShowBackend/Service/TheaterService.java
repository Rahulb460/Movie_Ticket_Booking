package com.example.bookMyShowBackend.Service;

import com.example.bookMyShowBackend.Converter.TheaterConverter;
import com.example.bookMyShowBackend.RequestDtos.TheaterRequestDto;
import com.example.bookMyShowBackend.Enums.SeatType;
import com.example.bookMyShowBackend.Models.TheaterEntity;
import com.example.bookMyShowBackend.Models.TheaterSeatEntity;
import com.example.bookMyShowBackend.Repository.TheaterRepository;
import com.example.bookMyShowBackend.Repository.TheaterSeatRepository;
import com.example.bookMyShowBackend.ResponseDtos.TheaterResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    TheaterSeatRepository theaterSeatRepository;

    @Autowired
    TheaterRepository theaterRepository;

    public String createTheater(TheaterRequestDto theaterRequestDto) throws Exception{


        try{
            TheaterEntity theater = TheaterConverter.convertDtoToEntity(theaterRequestDto);
            List<TheaterSeatEntity> theaterSeats = createTheaterSeats();
            theater.setTheaterSeatEntityList(theaterSeats);

            for(TheaterSeatEntity theaterSeat : theaterSeats){
                theaterSeat.setTheater(theater);
            }
            theaterRepository.save(theater);

            return "Theatre added successfully!";
        }
        catch (Exception e){
            throw new Exception("Not able to add requested theatre!!");
        }

    }

    private List<TheaterSeatEntity> createTheaterSeats(){


        List<TheaterSeatEntity> seats = new ArrayList<>();


        for(int i=0;i<5;i++){

            char ch = (char)('A'+i);

            String seatNo  = "1"+ ch;
            TheaterSeatEntity theaterSeat = new TheaterSeatEntity(seatNo, SeatType.CLASSIC,100);
            seats.add(theaterSeat);
        }
        for(int i=0;i<5;i++){
            char ch = (char)('A'+i);
            String seatNo  = "2"+ ch;
            TheaterSeatEntity theaterSeat = new TheaterSeatEntity(seatNo,SeatType.PLATINUM,200);
            seats.add(theaterSeat);
        }

        theaterSeatRepository.saveAll(seats);

        return seats;

    }

    public TheaterResponseDto getTheaterById(int id){
        try {
           TheaterEntity theaterEntity = theaterRepository.findById(id).get();
            TheaterResponseDto theaterResponseDto = TheaterConverter.convertEntityToDto(theaterEntity);
            return theaterResponseDto;
        }
        catch (Exception e){
            throw new RuntimeException("No theatre found with requested id!!");
        }
    }
    public  List<TheaterResponseDto> getAllTheater() {
        try {
            List<TheaterEntity> theaters = theaterRepository.findAll();
            List<TheaterResponseDto> dtoList = new ArrayList<>();

            for(TheaterEntity theater : theaters){
                TheaterResponseDto theaterResponseDto = TheaterConverter.convertEntityToDto(theater);
                dtoList.add(theaterResponseDto);
            }
            return dtoList;
        }
        catch (Exception e){
            throw new RuntimeException("No theatres found in the database!!");
        }
    }


}
