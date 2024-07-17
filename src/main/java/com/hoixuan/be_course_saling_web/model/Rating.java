package com.hoixuan.be_course_saling_web.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Data
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRating;
    @Column(length = 1000000)
    private String contentRating;
    private int numStar;
    private boolean statusRating;
    private Date timeRating;
    @ManyToOne
    private AppUser appUser;
    @ManyToOne
    private Course course;
}
