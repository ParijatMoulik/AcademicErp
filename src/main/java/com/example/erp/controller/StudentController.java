package com.example.erp.controller;

import com.example.erp.bean.Employee;
import com.example.erp.bean.Student;
import com.example.erp.service.EmployeeService;
import com.example.erp.service.StudentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Path("student")
public class StudentController {
    StudentService studentService = new StudentService();
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchStudents(){
        List<Student> students = studentService.getCourses();
        return Response.ok().entity(students).build();
    }
}
