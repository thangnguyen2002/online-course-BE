package com.hoixuan.be_course_saling_web.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Data
@Entity
public class MyCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMyCourse;
    @ManyToOne
    private AppUser appUser;
    @ManyToOne
    private Course course;
    private double completionProgress;
    private Date expire;
    private boolean statusMyCourse = true;
    @OneToMany
    private Set<Lesson> lessonList;
    @OneToOne
    private Certificate certificate;
}
