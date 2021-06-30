package com.example.erp.bean;

import java.util.List;

public class PlacementSelection {
    private List<String> student_ids;
    private List<String> placement_ids;

    public PlacementSelection(List<String> student_ids, List<String> placement_ids) {
        this.student_ids = student_ids;
        this.placement_ids = placement_ids;
    }

    public PlacementSelection() {
    }

    public List<String> getStudent_ids() {
        return student_ids;
    }

    public void setStudent_ids(List<String> student_ids) {
        this.student_ids = student_ids;
    }

    public List<String> getPlacement_ids() {
        return placement_ids;
    }

    public void setPlacement_ids(List<String> placement_ids) {
        this.placement_ids = placement_ids;
    }

    @Override
    public String toString() {
        return "PlacementSelection{" +
                "student_ids=" + student_ids +
                ", placement_ids=" + placement_ids +
                '}';
    }
}



