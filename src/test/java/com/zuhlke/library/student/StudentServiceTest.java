package com.zuhlke.library.student;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.zuhlke.library.domain.Student;
import com.zuhlke.library.repositories.StudentRepository;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest {

    @Mock StudentRepository mockRepository;
    @InjectMocks StudentService StudentService = new StudentService();
    
    @Test
    public void shouldGetStudentById() throws Exception {
        StudentService.getStudent(1L);
        verify(mockRepository).findOne(1L);
    }
    
    @Test
    public void shouldFindAllStudents() throws Exception {
        StudentService.findStudents(null);
        verify(mockRepository).findAll();
    }
    
    @Test
    public void shouldFindStudentsByQuery() throws Exception {
        StudentService.findStudents("Query");
        verify(mockRepository).findByFirstname("query");
    }
    
    @Test
    public void shouldSaveStudent() throws Exception {
        Student Student = new Student().withId(1L);
        StudentService.saveStudent(Student);
        verify(mockRepository).save(Student);
    }
    
    @Test
    public void shouldDeleteStudent() throws Exception {
        Student student = new Student().withId(2L);
        when(mockRepository.findOne(2L)).thenReturn(student);
        StudentService.deleteStudent(2L);
        verify(mockRepository).delete(student);
    }
    
}
