package com.example.bookMyShowBackend.Controllers;

import com.example.bookMyShowBackend.RequestDtos.TheaterRequestDto;
import com.example.bookMyShowBackend.Models.TheaterEntity;
import com.example.bookMyShowBackend.ResponseDtos.TheaterResponseDto;
import com.example.bookMyShowBackend.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    TheaterService theaterService;


    // Add a theater
    @PostMapping("/add")
    public ResponseEntity<String> createTheater(@RequestBody()TheaterRequestDto theaterRequestDto) throws Exception{
        String result = theaterService.createTheater(theaterRequestDto);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    //Get theater by theaterId
    @GetMapping("/get_theater_by_id")
    public ResponseEntity<TheaterResponseDto> getTheaterByID(@RequestParam int id) throws Exception{
      TheaterResponseDto theaterResponseDto = theaterService.getTheaterById(id);
        return new ResponseEntity<>(theaterResponseDto, HttpStatus.OK);
    }

    //Get all theaters
    @GetMapping("/get_all_theaters")
    public ResponseEntity<List<TheaterResponseDto>> getAllTheater() {
        List<TheaterResponseDto> theaterEntityList = theaterService.getAllTheater();
        return new ResponseEntity<>(theaterEntityList, HttpStatus.OK);
    }
}

