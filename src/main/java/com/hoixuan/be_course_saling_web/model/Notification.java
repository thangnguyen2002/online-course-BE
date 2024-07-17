package com.hoixuan.be_course_saling_web.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idNotification;
    private String title;
    private Date timeNotification;
    @ManyToOne
    private AppUser appUser;
    private boolean status;
    private String sendTo;
    private String type;
    private String linkId;
}
