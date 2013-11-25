package com.zuhlke.library.student;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;
import com.zuhlke.library.domain.Student;
import com.zuhlke.library.domain.json.Views;

/**
 * REST Resource for /books
 *
 */
@Component
@Path("/students")
public class StudentResource {

    final Logger logger = LoggerFactory.getLogger(StudentResource.class);
    
    @Inject
    private StudentService studentService;
    
    @GET 
    @Produces(MediaType.APPLICATION_JSON) @JsonView(Views.Book.class)
    public List<Student> getStudents(@QueryParam("q") String query) {
        return studentService.findStudents(query);
    }
    
    @GET @Path("/{id}") 
    @Produces(MediaType.APPLICATION_JSON) @JsonView(Views.Book.class)
    public Student getStudent(@PathParam("id") Long id) {
        Student student = studentService.getStudent(id);
        if (student != null) {
            return student;
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }
    
    @POST 
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveStudent(Student student) {
    	studentService.saveStudent(student);
    }

    @DELETE @Path("/{id}") 
    public void deleteStudent(@PathParam("id") Long id) {
    	studentService.deleteStudent(id);
    }

}

