package com.example.erp.dao;
import java.util.List;
import com.example.erp.bean.Student;
public interface StudentDao {
    List<Student> fetchStudent();
    Student fetchStudentId(String student_id);

    List<String> filterByDomainStudents(String domain_name);

    List<String> filterBySpecialisationStudents(String specialisation);
}
