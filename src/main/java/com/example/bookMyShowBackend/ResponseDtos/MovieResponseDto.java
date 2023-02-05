package com.example.bookMyShowBackend.ResponseDtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponseDto {

    private String movieName;

    private int duration;

    private Date releaseDate;

    private List<ShowResponseDto> showList;

}
