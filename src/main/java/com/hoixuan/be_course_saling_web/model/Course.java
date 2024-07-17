package com.hoixuan.be_course_saling_web.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCourse;
    @Column(unique = true)
    private String nameCourse;
    private double priceCourse;
    @Column(length = 1000000)
    private String imgCourse;
    private int enrolled;
    @Column(length = 100000)
    private String shortDescription;
    @Column(length = 100000)
    private String descriptionCourse;
    private int timeCourse;
    @ManyToOne
    private Instructor instructor;
    private int quantity = 0;
    private boolean statusCourse = true;
    private int numRating = 5 ;
    private int numLesson = 0;
    @OneToOne
    private Quiz quiz;

    @Transient
    private double similarityScore; // Trường này không được lưu vào cơ sở dữ liệu

}
