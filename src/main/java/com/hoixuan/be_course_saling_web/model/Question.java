package com.hoixuan.be_course_saling_web.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idQuestion;
    private String contentQuestion;
    private String A;
    private String B;
    private String C;
    private String D;
    private String answer;
    @ManyToOne
    private Quiz quiz;
}
