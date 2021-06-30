package com.example.erp.dao;
import java.util.List;

import com.example.erp.bean.*;

public interface PlacementStudentDao {
    List<Placement_Student> fetchPlacementStudent();

    List<Placement_Student> filterByDomain(Student domain_name);

    int updatePlacementStatus(PlacementSelection request);

    List<Placement_Student> filterBySpecialisation(Student specialisation);
}
