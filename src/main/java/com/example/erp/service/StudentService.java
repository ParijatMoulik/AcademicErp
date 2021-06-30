package com.example.erp.service;

import com.example.erp.bean.Student;
import com.example.erp.dao.StudentDao;
import com.example.erp.dao.implementation.StudentDaoImpl;

import java.util.List;

public class StudentService {

    StudentDao studentDao = new StudentDaoImpl();
//    public boolean registerCourse(Courses course){
//        return courseDao.registerCourse(course);
//    }

    public List<Student> getCourses (){
        return studentDao.fetchStudent();
    }

    public Student getStudentId(String student_id){return studentDao.fetchStudentId(student_id);}

    public List<String> filterbyDomainStudents(String domain_name) { return studentDao.filterByDomainStudents(domain_name); }

    public List<String> filterBySpecialisationStudents(String specialisation) { return studentDao.filterBySpecialisationStudents(specialisation); }

//    public Courses getCourseByID(Integer id){
//        return courseDao.getCourseByID(id);
//    }
}
