package com.example.bookMyShowBackend.ResponseDtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TheaterResponseDto {
    private String name;

    private String city;

    private String address;

    private int seatCount;
}
