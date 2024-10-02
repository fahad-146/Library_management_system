package com.whiteBin.student_library_management_system.repository;

import com.whiteBin.student_library_management_system.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {

}