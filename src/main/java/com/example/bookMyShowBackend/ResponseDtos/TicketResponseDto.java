package com.example.bookMyShowBackend.ResponseDtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponseDto {


    private String allotedSeats;

    private int amount;

    private ShowResponseDto show;

    private Date bookedAt;
}
