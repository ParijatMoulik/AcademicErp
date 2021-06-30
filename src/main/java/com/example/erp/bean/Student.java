package com.example.erp.bean;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String student_id;

    @Column(nullable = false, unique = true)
    private String roll_number;

    @Column(nullable = false)
    private String first_name;

    private String last_name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, columnDefinition = "String default 0.0")
    private String cgpa;

    @Column(nullable = false)
    private String total_credits;

    private String graduation_year;

    private String domain;
    private String specialisation;
    private String placement_id;

    public Student() {
    }

    public Student(String student_id, String roll_number, String first_name, String last_name, String email, String cgpa,
                   String total_credits, String graduation_year, String domain, String specialisation, String placement_id) {
        this.student_id = student_id;
        this.roll_number = roll_number;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.cgpa = cgpa;
        this.total_credits = total_credits;
        this.graduation_year = graduation_year;
        this.domain = domain;
        this.specialisation = specialisation;
        this.placement_id = placement_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(String roll_number) {
        this.roll_number = roll_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public String getTotal_credits() {
        return total_credits;
    }

    public void setTotal_credits(String total_credits) {
        this.total_credits = total_credits;
    }

    public String getGraduation_year() {
        return graduation_year;
    }

    public void setGraduation_year(String graduation_year) {
        this.graduation_year = graduation_year;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public String getPlacement_id() {
        return placement_id;
    }

    public void setPlacement_id(String placement_id) {
        this.placement_id = placement_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id='" + student_id + '\'' +
                ", roll_number='" + roll_number + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", cgpa='" + cgpa + '\'' +
                ", total_credits='" + total_credits + '\'' +
                ", graduation_year='" + graduation_year + '\'' +
                ", domain='" + domain + '\'' +
                ", specialisation='" + specialisation + '\'' +
                ", placement_id='" + placement_id + '\'' +
                '}';
    }
}

