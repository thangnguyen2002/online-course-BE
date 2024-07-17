package com.hoixuan.be_course_saling_web.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idComment;
    @Column(length = 1000000)
    private String contentCmt;
    private Date timeCmt;
    @ManyToOne
    private AppUser appUser;
    @ManyToOne
    private Course course;
}
