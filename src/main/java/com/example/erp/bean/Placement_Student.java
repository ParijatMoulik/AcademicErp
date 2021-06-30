package com.example.erp.bean;

import javax.persistence.*;

@Entity
@Table(name = "placement_student")
public class Placement_Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String placement_id;
    private String student_id;
    private String cv_application;
    private String about;

    @Column(columnDefinition = "String default PENDING")
    private String acceptance;

    private String comments;
    private String date;

    public Placement_Student() {}

    public Placement_Student(String id, String placement_id, String student_id, String cv_application, String about, String acceptance, String comments, String date) {
        this.id = id;
        this.placement_id = placement_id;
        this.student_id = student_id;
        this.cv_application = cv_application;
        this.about = about;
        this.acceptance = acceptance;
        this.comments = comments;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlacement_id() {
        return placement_id;
    }

    public void setPlacement_id(String placement_id) {
        this.placement_id = placement_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getCv_application() {
        return cv_application;
    }

    public void setCv_application(String cv_application) {
        this.cv_application = cv_application;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getAcceptance() {
        return acceptance;
    }

    public void setAcceptance(String acceptance) {
        this.acceptance = acceptance;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Placement_Student{" +
                "id='" + id + '\'' +
                ", placement_id='" + placement_id + '\'' +
                ", student_id='" + student_id + '\'' +
                ", cv_application='" + cv_application + '\'' +
                ", about='" + about + '\'' +
                ", acceptance='" + acceptance + '\'' +
                ", comments='" + comments + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
