package com.example.erp.service;
import com.example.erp.bean.PlacementSelection;
import com.example.erp.bean.Placement_Student;
import com.example.erp.bean.Random;
import com.example.erp.bean.Student;
import com.example.erp.dao.PlacementStudentDao;
import com.example.erp.dao.implementation.PlacementStudentDaoImpl;

import java.util.List;

public class PlacementStudentService {
    PlacementStudentDao placementStudentDao = new PlacementStudentDaoImpl();
    public List<Placement_Student> getPlacementStudents (){
        return placementStudentDao.fetchPlacementStudent();
    }

    public List<Placement_Student> filterByDomain(Student domain_name) { return placementStudentDao.filterByDomain(domain_name); }

    public List<Placement_Student> filterBySpecialisation(Student specialisation) { return placementStudentDao.filterBySpecialisation(specialisation); }
}
