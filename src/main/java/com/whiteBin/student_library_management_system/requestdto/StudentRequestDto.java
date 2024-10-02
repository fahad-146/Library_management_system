package com.whiteBin.student_library_management_system.requestdto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class StudentRequestDto {
    private String name;
    private int age;
    private String email;
    private String mobile;
    private String gender;

}
