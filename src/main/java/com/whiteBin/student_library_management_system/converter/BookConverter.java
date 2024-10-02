package com.whiteBin.student_library_management_system.converter;

import com.whiteBin.student_library_management_system.model.Book;
import com.whiteBin.student_library_management_system.requestdto.BookRequestDto;

public class BookConverter {

    //converter - convert the requestDto into model classes
    public static Book convertBookRequestDtoIntoModel(BookRequestDto bookRequestDto){
        Book book = Book.builder().pages(bookRequestDto.getPages()).genre(bookRequestDto.getGenre())
                .title(bookRequestDto.getTitle()).quantity(bookRequestDto.getQuantity()).build();
        return book;
    }
}
