package com.whiteBin.student_library_management_system.repository;

import com.whiteBin.student_library_management_system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    //writing our own methods for performing database queries using fields/attributes of model class

    //writing our own methods for performing database queries using our own queries


}
