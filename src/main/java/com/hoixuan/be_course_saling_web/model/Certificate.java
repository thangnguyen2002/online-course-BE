package com.hoixuan.be_course_saling_web.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Entity
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCertificate;
    @Column(length = 1000000)
    private String imageCertificate;
    @ManyToOne
    private Course course;
    @ManyToOne
    private AppUser appUser;
    private Date createAt;
}
