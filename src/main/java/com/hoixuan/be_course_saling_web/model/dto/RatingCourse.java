package com.hoixuan.be_course_saling_web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingCourse {
    private int idCourse;
    private String contentRating;
    private int numStar;
}
