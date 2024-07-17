package com.hoixuan.be_course_saling_web.model;

import lombok.Data;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBill;
    private Date createAt;
    @OneToOne
    private Course course;
    @ManyToOne
    private AppUser appUser;
    private double totalBill;
    private boolean status;
    private String contentBill;
    private String paymentMethod;
}
