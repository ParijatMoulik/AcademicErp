package com.example.erp.service;

import com.example.erp.bean.Placement;
import com.example.erp.dao.PlacementDao;
import com.example.erp.dao.implementation.PlacementDaoImpl;

import java.util.List;

public class PlacementService {

    PlacementDao placementDao = new PlacementDaoImpl();
//    public boolean registerCourse(Courses course){
//        return courseDao.registerCourse(course);
//    }

    public Placement getPlacement (String placement_id){
        return placementDao.fetchPlacementId(placement_id);
    }

//    public Courses getCourseByID(Integer id){
//        return courseDao.getCourseByID(id);
//    }
}
