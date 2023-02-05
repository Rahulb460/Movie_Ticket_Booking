package com.example.bookMyShowBackend.Converter;

import com.example.bookMyShowBackend.Models.UserEntity;
import com.example.bookMyShowBackend.RequestDtos.UserRequestDto;
import com.example.bookMyShowBackend.ResponseDtos.UserResponseDto;

public class UserConverter {
    public static UserEntity convertDtoToEntity(UserRequestDto userRequestDto){

        UserEntity user = UserEntity.builder().
                name(userRequestDto.getName()).
                mobile(userRequestDto.getMobile()).build();

        return user;
    }

    public static UserResponseDto convertEntityToDto(UserEntity user) {

        UserResponseDto userResponseDto = UserResponseDto.builder().name(user.getName()).mobile(user.getMobile()).
                tickets(TicketConverter.convertEntityToDto(user)).build();

        return userResponseDto;
    }
}
