package com.example.bookMyShowBackend.Controllers;

import com.example.bookMyShowBackend.RequestDtos.UserRequestDto;
import com.example.bookMyShowBackend.ResponseDtos.UserResponseDto;
import com.example.bookMyShowBackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody UserRequestDto userRequestDto){

        return userService.createUser(userRequestDto);

    }

    //Find UserBy Name h.w
    @GetMapping("/get_user_by_name")
    public  ResponseEntity<List<UserResponseDto>> getUserByName(@RequestParam String userName){
        List<UserResponseDto> list = userService.getUserByName(userName);
        return new ResponseEntity<>(list, HttpStatus.FOUND);
    }

    // find user by mobile number
    @GetMapping("/get_user_by_mobile")
    public ResponseEntity<UserResponseDto> getUserByMobile(@RequestParam String mobile){
        UserResponseDto user = userService.getUserByMobile(mobile);
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    //Get all Users
    @GetMapping("/get_all")
    public ResponseEntity<List<UserResponseDto>> getAllUsers(){
        List<UserResponseDto> list = userService.getAllUsers();
        return new ResponseEntity<>(list, HttpStatus.FOUND);
    }

}
