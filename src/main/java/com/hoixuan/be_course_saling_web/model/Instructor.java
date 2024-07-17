package com.hoixuan.be_course_saling_web.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
@Entity
@Data
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idInstructor;
    private String nameInstructor;
    @Email
    private String emailInstructor;
    private Date dateOfBirthInstructor;
    private String phoneInstructor;
    @Column(length = 1000000)
    private String AvatarInstructor;
    private int experience;
    @Column(length = 1000000)
    private String instructorDescribe;

}
