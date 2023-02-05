package com.example.bookMyShowBackend.ResponseDtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowResponseDto {
    private int showId;
    private LocalDate showDate;

    private LocalTime showTime;
    private String theatreName;

    private String theatreAddress;


}
