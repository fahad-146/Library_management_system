package com.whiteBin.student_library_management_system.service;

import com.whiteBin.student_library_management_system.converter.AuthorConverter;
import com.whiteBin.student_library_management_system.model.Author;
import com.whiteBin.student_library_management_system.repository.AuthorRepository;
import com.whiteBin.student_library_management_system.requestdto.AuthorRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorSerivce {

    @Autowired
    private AuthorRepository authorRepository;
    public String saveAuthor(AuthorRequestDto authorRequestDto){
        Author author= AuthorConverter.convertAuthorRequestDtoIntoAuthorModel(authorRequestDto);
        authorRepository.save(author);
        return "Author saved successfully";
    }
}
