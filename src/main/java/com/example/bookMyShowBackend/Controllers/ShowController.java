package com.example.bookMyShowBackend.Controllers;

import com.example.bookMyShowBackend.RequestDtos.ShowRequestDto;
import com.example.bookMyShowBackend.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    ShowService showService;

    // Add a show
    @PostMapping("/add")
    public String addShow(@RequestBody ShowRequestDto showRequestDto){

        return showService.addShow(showRequestDto);
    }

}
