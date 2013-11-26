package com.zuhlke.library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zuhlke.library.domain.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("select s from Teacher s where lower(s.firstname) like %?1% or lower(s.lastname) like %?1%")
    List<Teacher> findByFirstname(final String query);
    
}

