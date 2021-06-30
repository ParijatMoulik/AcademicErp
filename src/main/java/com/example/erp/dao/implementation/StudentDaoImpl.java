package com.example.erp.dao.implementation;
import com.example.erp.bean.Employee;
import com.example.erp.bean.Placement;
import com.example.erp.bean.Student;
import com.example.erp.dao.StudentDao;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> fetchStudent() {
        Session session = SessionUtil.getSession();
        List<Student> students = new ArrayList<>();
        try {
            for (final Object course : session.createQuery("from Student").list()) {
                students.add((Student) course);
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return students;
    }

    public Student fetchStudentId(String student_id){
        try(Session session = SessionUtil.getSession()){
            Query query = session.createQuery("from Student where id=:placementId");
            query.setParameter("placementId", student_id);
            for(final Object fetch:query.list())
                return (Student) fetch;
        }
        catch(HibernateException exception){
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        return null;
    }

    public List<String> filterByDomainStudents(String domain_name){
        List<String> studentIds = new ArrayList<>();
        try(Session session = SessionUtil.getSession()){
            Query query = session.createQuery("from Student where domain=:domain_name");
            query.setParameter("domain_name", domain_name);
            for(final Object o : query.list())
                studentIds.add(((Student) o).getStudent_id());
        }
        catch(HibernateException exception){
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        return studentIds;
    }

    public List<String> filterBySpecialisationStudents(String specialisation){
        List<String> studentIds = new ArrayList<>();
        try(Session session = SessionUtil.getSession()){
            Query query = session.createQuery("from Student where specialisation=:specialisation");
            query.setParameter("specialisation", specialisation);
            for(final Object o : query.list())
                studentIds.add(((Student) o).getStudent_id());
        }
        catch(HibernateException exception){
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        return studentIds;
    }
}