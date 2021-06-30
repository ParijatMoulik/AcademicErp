package com.example.erp.bean;

public class Random {
    private String about;
    private String cv;
    private Student student;
    private Placement placement;

    public Random() {
    }

    public Random(String about, String cv, Student student, Placement placement) {
        this.about = about;
        this.cv = cv;
        this.student = student;
        this.placement = placement;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Placement getPlacement() {
        return placement;
    }

    public void setPlacement(Placement placement) {
        this.placement = placement;
    }

    @Override
    public String toString() {
        return "Random{" +
                "about='" + about + '\'' +
                ", cv='" + cv + '\'' +
                ", student=" + student +
                ", placement=" + placement +
                '}';
    }
}
