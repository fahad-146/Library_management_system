package com.whiteBin.student_library_management_system.requestdto;

import com.whiteBin.student_library_management_system.enums.Genre;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class BookRequestDto {

    private String title;
    private int pages;
//    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    private int quantity;
    private int authorId;
}
