package com.hoixuan.be_course_saling_web.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idWallet;
    private double money;
    @OneToOne
    private AppUser appUser;

}
