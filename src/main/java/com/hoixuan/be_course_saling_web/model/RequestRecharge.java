package com.hoixuan.be_course_saling_web.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class RequestRecharge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRequest;
    private double money;
    @ManyToOne
    private AppUser appUser;
    private Date createAt;
    private String paymentMethod;
    private boolean status;
}
