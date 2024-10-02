package com.whiteBin.student_library_management_system.converter;

import com.whiteBin.student_library_management_system.model.Student;
import com.whiteBin.student_library_management_system.requestdto.StudentRequestDto;

public class StudentConverter {

    //converter - convert the request dto into model classes
    public static Student convertStudentRequestDtoIntoStudentModel(StudentRequestDto studentRequestDto){
        Student student= Student.builder().name(studentRequestDto.getName()).age(studentRequestDto.getAge())
                .email(studentRequestDto.getEmail()).gender(studentRequestDto.getGender())
                .mobile(studentRequestDto.getMobile()).build();
        return student;
    }
}
