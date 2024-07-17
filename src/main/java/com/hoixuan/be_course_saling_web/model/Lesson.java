package com.hoixuan.be_course_saling_web.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idLesson;
    private String nameLesson;
    private String contentLesson;
    @Column(length = 1000000)
    private String linkVideo;
    private String timeLesson;
    @ManyToOne
    private Course course;

}
