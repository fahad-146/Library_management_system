package com.whiteBin.student_library_management_system.controller;


import com.whiteBin.student_library_management_system.requestdto.AuthorRequestDto;
import com.whiteBin.student_library_management_system.service.AuthorSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author/api")
public class AuthorController {

    @Autowired
    private AuthorSerivce authorSerivce;

    @PostMapping("/create")
    public String saveAuthor(@RequestBody AuthorRequestDto authorRequestDto){
        String response= authorSerivce.saveAuthor(authorRequestDto);
        return response;
    }
}
