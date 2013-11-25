package com.zuhlke.library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zuhlke.library.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student s where lower(s.firstname) like %?1% or lower(s.lastname) like %?1%")
    List<Student> findByFirstname(final String query);
    
}

