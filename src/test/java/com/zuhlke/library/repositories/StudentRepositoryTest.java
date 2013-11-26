package com.zuhlke.library.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.zuhlke.library.domain.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/data-context.xml")
public class StudentRepositoryTest {

    @Inject StudentRepository studentRepository;
    @Inject TransactionTemplate transactionTemplate;
    
    @Test
    public void shouldStudentFindById() throws Exception {
        Student student = transactionTemplate.execute(new TransactionCallback<Student>() {
            @Override
            public Student doInTransaction(TransactionStatus status) {
                return studentRepository.findOne(1L);
            }
        });
        
        assertNotNull(student);
        assertEquals(new Long(1), student.getId());
        
    }
    
    @Ignore
    @Test
    public void shouldFindStudentByName() throws Exception {
        List<Student> students = transactionTemplate.execute(new TransactionCallback<List<Student>>() {
            @Override
            public List<Student> doInTransaction(TransactionStatus status) {
                return studentRepository.findByFirstname("java");
            }
        });

        assertEquals(1, students.size());
        assertEquals(new Long(3), students.get(0).getId());
        
    }
    
    @Ignore
    public void shouldFindStudentByAuthor() throws Exception {
        List<Student> students = transactionTemplate.execute(new TransactionCallback<List<Student>>() {
            @Override
            public List<Student> doInTransaction(TransactionStatus status) {
                return studentRepository.findByFirstname("John");
            }
        });
        
        assertEquals(1, students.size());
        assertEquals(new Long(3), students.get(0).getId());
    }
    
}
