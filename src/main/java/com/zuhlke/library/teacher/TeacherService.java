package com.zuhlke.library.teacher;

import static com.google.common.base.Strings.isNullOrEmpty;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zuhlke.library.domain.Teacher;
import com.zuhlke.library.repositories.TeacherRepository;

/**
 * Manages teachers
 *
 */
@Service
public class TeacherService {

    @Inject
    private TeacherRepository teacherRepository;

    @Transactional(readOnly = true)
    public Teacher getTeacher(long id) {
        return teacherRepository.findOne(id);
    }
    
    @Transactional(readOnly = true)
    public List<Teacher> findTeachers(String query) {
        if (isNullOrEmpty(query)) {
            return teacherRepository.findAll();
        } else {
            return teacherRepository.findByFirstname(query.toLowerCase());
        }
    }
    
    @Transactional
    public void saveTeacher(Teacher teacher) {
    	teacherRepository.save(teacher);
    }
    
    @Transactional
    public void deleteTeacher(long id) {
    	teacherRepository.delete(teacherRepository.findOne(id));
    }
   
}

