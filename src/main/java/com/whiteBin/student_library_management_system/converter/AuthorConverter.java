package com.whiteBin.student_library_management_system.converter;

import com.whiteBin.student_library_management_system.model.Author;
import com.whiteBin.student_library_management_system.requestdto.AuthorRequestDto;


public class AuthorConverter {

    //converter - convert the request dto into model classes
    public static Author convertAuthorRequestDtoIntoAuthorModel(AuthorRequestDto authorRequestDto){
        Author author=Author.builder().name(authorRequestDto.getName()).age(authorRequestDto.getAge()).country(authorRequestDto.getCountry())
                .rating(authorRequestDto.getRating()).build();
        return author;
    }
}
