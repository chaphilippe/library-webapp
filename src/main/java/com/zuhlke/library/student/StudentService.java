package com.zuhlke.library.student;

import static com.google.common.base.Strings.isNullOrEmpty;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zuhlke.library.domain.Student;
import com.zuhlke.library.repositories.StudentRepository;

/**
 * Manages students
 *
 */
@Service
public class StudentService {

    @Inject
    private StudentRepository studentRepository;

    @Transactional(readOnly = true)
    public Student getStudent(long id) {
        return studentRepository.findOne(id);
    }
    
    @Transactional(readOnly = true)
    public List<Student> findStudents(String query) {
        if (isNullOrEmpty(query)) {
            return studentRepository.findAll();
        } else {
            return studentRepository.findByFirstname(query.toLowerCase());
        }
    }
    
    @Transactional
    public void saveStudent(Student student) {
    	studentRepository.save(student);
    }
    
    @Transactional
    public void deleteStudent(long id) {
    	studentRepository.delete(studentRepository.findOne(id));
    }
   
}

