package com.example.bookMyShowBackend.Converter;

import com.example.bookMyShowBackend.Models.TicketEntity;
import com.example.bookMyShowBackend.Models.UserEntity;
import com.example.bookMyShowBackend.ResponseDtos.TicketResponseDto;

import java.util.ArrayList;
import java.util.List;

public class TicketConverter {

    public static List<TicketResponseDto> convertEntityToDto(UserEntity user) {
        List<TicketEntity> ticketList = user.getListOfTickets();
        List<TicketResponseDto> dtoList = new ArrayList<>();

        for (TicketEntity ticket : ticketList) {
            TicketResponseDto ticketResponseDto = TicketResponseDto.builder().
                    allotedSeats(ticket.getAlloted_seats()).amount(ticket.getAmount()).
                    bookedAt(ticket.getBooked_at()).
                    show(ShowConverter.convertEntityToDto(ticket.getShow())).build();

            dtoList.add(ticketResponseDto);
        }

        return dtoList;
    }

}
