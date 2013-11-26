package com.zuhlke.library.teacher;

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
import com.zuhlke.library.domain.Teacher;
import com.zuhlke.library.domain.json.Views;

/**
 * REST Resource for /teachers
 *
 */
@Component
@Path("/teachers")
public class TeacherResource {

    final Logger logger = LoggerFactory.getLogger(TeacherResource.class);
    
    @Inject
    private TeacherService teacherService;
    
    @GET 
    @Produces(MediaType.APPLICATION_JSON) @JsonView(Views.Teacher.class)
    public List<Teacher> getTeachers(@QueryParam("q") String query) {
        return teacherService.findTeachers(query);
    }
    
    @GET @Path("/{id}") 
    @Produces(MediaType.APPLICATION_JSON) @JsonView(Views.Teacher.class)
    public Teacher getTeachert(@PathParam("id") Long id) {
        Teacher teacher = teacherService.getTeacher(id);
        if (teacher != null) {
            return teacher;
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }
    
    @POST 
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveTeacher(Teacher teacher) {
    	teacherService.saveTeacher(teacher);
    }

    @DELETE @Path("/{id}") 
    public void deleteTeacher(@PathParam("id") Long id) {
    	teacherService.deleteTeacher(id);
    }

}

