package com.example.bookMyShowBackend.Service;

import com.example.bookMyShowBackend.RequestDtos.UserRequestDto;
import com.example.bookMyShowBackend.Models.UserEntity;
import com.example.bookMyShowBackend.Converter.UserConverter;
import com.example.bookMyShowBackend.Repository.UserRepository;
import com.example.bookMyShowBackend.ResponseDtos.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;


    // Create user
    public String createUser(UserRequestDto userRequestDto){

        //Converted the userRequestDto to UserEntity
        UserEntity userEntity = UserEntity.builder().name(userRequestDto.getName()).mobile(userRequestDto.getMobile()).build();

        try{
            userRepository.save(userEntity);

        }catch(Exception e){
            return "user couldn't be added";
        }
        return "User added successfully";
    }

    public List<UserResponseDto> getUserByName(String userName) {

        try{
            List<UserEntity> users = userRepository.findUserByName(userName);
            List<UserResponseDto> dtoList = new ArrayList<>();

            for(UserEntity user : users){
                UserResponseDto userResponseDto = UserConverter.convertEntityToDto(user);
                dtoList.add(userResponseDto);
            }
            return dtoList;
        }
        catch (Exception e){
            throw new RuntimeException("Error fetching User by name!!");
        }

    }

    public UserResponseDto getUserByMobile(String mobile) {
        try{
            UserEntity user = userRepository.findByMobile(mobile);
            UserResponseDto userResponseDto = UserConverter.convertEntityToDto(user);
            return userResponseDto;
        }
        catch (Exception e) {
            throw new RuntimeException("Error fetching User by mobile!!");
        }
    }

    public List<UserResponseDto> getAllUsers() {
        try {
            List<UserEntity> users = userRepository.findAll();
            List<UserResponseDto> dtoList = new ArrayList<>();

            for(UserEntity user : users){
                UserResponseDto userResponseDto = UserConverter.convertEntityToDto(user);
                dtoList.add(userResponseDto);
            }
            return dtoList;
        }
        catch (Exception e){
            throw new RuntimeException("Error fetching Users!!");
        }
    }



}