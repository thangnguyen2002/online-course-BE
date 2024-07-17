package com.hoixuan.be_course_saling_web.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idQuiz;
    private String nameQuiz;
    private long numberOfQuiz;
    private int timeQuiz;
}
