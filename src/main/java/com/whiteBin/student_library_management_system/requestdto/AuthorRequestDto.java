package com.whiteBin.student_library_management_system.requestdto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AuthorRequestDto {

    private String name;

    private String country;

    private int age;

    private double rating;
}
