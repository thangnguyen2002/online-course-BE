package com.hoixuan.be_course_saling_web.model.dto;

import lombok.Data;

@Data
public class Criteria {
    String nameCourse;
   int from;
    int to;
    int experience;
    String nameInstructor;
    int rating;
}
