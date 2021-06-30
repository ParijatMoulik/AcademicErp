package com.example.erp.dao.implementation;

import com.example.erp.bean.PlacementSelection;
import com.example.erp.bean.Placement_Student;
import com.example.erp.bean.Random;
import com.example.erp.bean.Student;
import com.example.erp.dao.PlacementStudentDao;
import com.example.erp.dao.StudentDao;
import com.example.erp.service.StudentService;
import com.example.erp.utils.SessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class PlacementStudentDaoImpl implements PlacementStudentDao {
    @Override
    public List<Placement_Student> fetchPlacementStudent() {
        Session session = SessionUtil.getSession();
        List<Placement_Student> placementStudents = new ArrayList<>();
        try {
            Query query = session.createQuery("from Placement_Student where acceptance=:accept");
            query.setParameter("accept", "PENDING");
            for (final Object ps : query.list()) {
                placementStudents.add((Placement_Student) ps);
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return placementStudents;
    }

    public List<Placement_Student> filterByDomain(Student domain_name){
        StudentService studentService = new StudentService();
        List<Placement_Student> placementStudents = new ArrayList<>();
        List<String> studentIds = studentService.filterbyDomainStudents(domain_name.getDomain());
        try(Session session = SessionUtil.getSession()){
            //Query query = session.createQuery("from Placement_Student where student_id=:studentId");
            Query query = session.createQuery("from Placement_Student where student_id=:studentId and acceptance=:default_acceptance");
            for(String studentId : studentIds){
                query.setParameter("studentId", studentId);
                query.setParameter("default_acceptance", "PENDING");
                for(final Object fetch : query.list()) {
                    placementStudents.add((Placement_Student) fetch);
                }
            }
        }
        catch (HibernateException exception){
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        return placementStudents;
    }

    public int updatePlacementStatus(PlacementSelection placementSelection){
        String hql = "update Student set placement_id=:placement_id where student_id=:student_id";
        int updatedEntities = 0;
        try(Session session = SessionUtil.getSession()){
            Transaction tx=session.beginTransaction();
            Query query_student = session.createQuery("update Student set placement_id=:placement_id where student_id=:student_id");
            Query query_placement = session.createQuery("update Placement_Student set acceptance=:accept where student_id=:student_id");
            for(int i=0; i<placementSelection.getPlacement_ids().size(); i++){
                query_student.setParameter("placement_id", placementSelection.getPlacement_ids().get(i));
                query_student.setParameter("student_id", placementSelection.getStudent_ids().get(i));
                updatedEntities+= query_student.executeUpdate();
                query_placement.setParameter("accept", "ACCEPTED");
                query_placement.setParameter("student_id", placementSelection.getStudent_ids().get(i));
                int entries = query_placement.executeUpdate();
                System.out.println("Placement ID : "+placementSelection.getPlacement_ids().get(i));
                System.out.println("Student ID : "+placementSelection.getStudent_ids().get(i));
            }
            tx.commit();
        }
        catch(HibernateException exception){
            System.out.println(exception.getLocalizedMessage());
        }
        System.out.println(updatedEntities);
        return updatedEntities;
    }

    public List<Placement_Student> filterBySpecialisation(Student specialisation){
        StudentService studentService = new StudentService();
        List<Placement_Student> placementStudents = new ArrayList<>();
        List<String> studentIds = studentService.filterBySpecialisationStudents(specialisation.getSpecialisation());
        try(Session session = SessionUtil.getSession()){
            //Query query = session.createQuery("from Placement_Student where student_id=:studentId" );
            Query query = session.createQuery("from Placement_Student where student_id=:studentId and acceptance=:default_acceptance" );
            for(String studentId : studentIds){
                query.setParameter("studentId", studentId);
                query.setParameter("default_acceptance", "PENDING");
                for(final Object fetch : query.list()) {
                    placementStudents.add((Placement_Student) fetch);
                }
            }
        }
        catch (HibernateException exception){
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        return placementStudents;
    }
}
