package com.hoixuan.be_course_saling_web.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Support {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSupport;
    private String contentSupport;
    @ManyToOne
    private AppUser appUser;
    private Date timeSupport;
}
