package com.whiteBin.student_library_management_system.service;

import com.whiteBin.student_library_management_system.converter.StudentConverter;
import com.whiteBin.student_library_management_system.enums.CardStatus;
import com.whiteBin.student_library_management_system.model.Card;
import com.whiteBin.student_library_management_system.model.Student;
import com.whiteBin.student_library_management_system.repository.StudentRepository;
import com.whiteBin.student_library_management_system.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String saveStudents(StudentRequestDto studentRequestDto){
        Student student=StudentConverter.convertStudentRequestDtoIntoStudentModel(studentRequestDto);

        Card card= new Card();
        card.setCardStatus(CardStatus.ACTIVE);
        card.setStudent(student);
        student.setCard(card);
        //save student object
        studentRepository.save(student);
        return "student and card saved successfully";
    }

    public String deleteStudentbyId(int studentId){
        studentRepository.deleteById(studentId);
        return "Student deleted successfully";
    }
}
