package com.hoixuan.be_course_saling_web.controller;

import com.hoixuan.be_course_saling_web.model.Course;
import com.hoixuan.be_course_saling_web.repository.ICourseRepo;
import com.hoixuan.be_course_saling_web.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recommend")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;
    @Autowired
    ICourseRepo courseRepo;

    @GetMapping("/{courseId}")
    public ResponseEntity<List<Course>> recommend(@PathVariable long courseId) {
        Course targetCourse = courseRepo.findByIdCourse(courseId);
        List<Course> recommendations = recommendationService.recommend(targetCourse, 5);
        List<Course> recommendations1 = new ArrayList<>();
        for (int i = 0; i < recommendations.size(); i++) {
            if (i == 4){
                break;
            }
            recommendations1.add(recommendations.get(i));
        }
        return ResponseEntity.ok(recommendations1);
    }
}

