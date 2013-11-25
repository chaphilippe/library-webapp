package com.zuhlke.library.student;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.zuhlke.library.domain.Student;

@RunWith(MockitoJUnitRunner.class)
public class StudentResourceTest {

    final List<Student> students = Arrays.asList(
        new Student().withId(14L).withFirstname("John").withAge("18").withDepartment("dep").withLastname("Smith").
        withIsCompetent(false).withIsScholarship(true).withSex("female").withIssueDate(new Date()),
        new Student().withId(12).withFirstname("Mark").withAge("18").withDepartment("dep").withLastname("Smith").
        withIsCompetent(false).withIsScholarship(true).withSex("female").withIssueDate(new Date()),
        new Student().withId(13L).withFirstname("Peter").withAge("18").withDepartment("dep").withLastname("Smith").
        withIsCompetent(false).withIsScholarship(true).withSex("female").withIssueDate(new Date())
    );
    
    final Student student = new Student().withId(1L).withFirstname("John").withAge("18").withDepartment("dep").withLastname("Smith").
            withIsCompetent(false).withIsScholarship(true).withSex("female").withIssueDate(new Date());

    @Mock StudentService mockStudentService;
    @InjectMocks StudentResource resource = new StudentResource();
    
    @Test
    public void shouldGetAllStudents() throws Exception {
        when(mockStudentService.findStudents(anyString())).thenReturn(students);
        List<Student> result = resource.getStudents(null);
        assertThat(students, is(result));
    }
    
    @Test
    public void shouldGetStudentsByQuery() throws Exception {
        when(mockStudentService.findStudents("title")).thenReturn(students);
        List<Student> result = resource.getStudents("title");
        assertThat(students, is(result));
    }
    
    @Test
    public void shouldGetStudentById() throws Exception {
        when(mockStudentService.getStudent(1L)).thenReturn(student);
        Student result = resource.getStudent(1L);
        assertThat(student, is(result));
    }
    
    @Test
    public void shouldSaveStudent() throws Exception {
        resource.saveStudent(student);
        verify(mockStudentService).saveStudent(student);
    }
    
    @Test
    public void shouldDeleteStudent() throws Exception {
        resource.deleteStudent(1L);
        verify(mockStudentService).deleteStudent(1L);
    }
    

}

