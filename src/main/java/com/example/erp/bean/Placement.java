package com.example.erp.bean;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "placement")
public class Placement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String organisation;

    @Column(nullable = false)
    private String profile;

    private String description;

    @Column(nullable = false)
    private String intake;

    private String minimum_grade;


    public Placement() {
    }

    public Placement(String id, String organisation, String profile, String description, String intake, String minimum_grade) {
        this.id = id;
        this.organisation = organisation;
        this.profile = profile;
        this.description = description;
        this.intake = intake;
        this.minimum_grade = minimum_grade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIntake() {
        return intake;
    }

    public void setIntake(String intake) {
        this.intake = intake;
    }

    public String getMinimum_grade() {
        return minimum_grade;
    }

    public void setMinimum_grade(String minimum_grade) {
        this.minimum_grade = minimum_grade;
    }

    @Override
    public String toString() {
        return "Placement{" +
                "id='" + id + '\'' +
                ", organisation='" + organisation + '\'' +
                ", profile='" + profile + '\'' +
                ", description='" + description + '\'' +
                ", intake='" + intake + '\'' +
                ", minimum_grade='" + minimum_grade + '\'' +
                '}';
    }
}
