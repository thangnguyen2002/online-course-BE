package com.hoixuan.be_course_saling_web.service;

import com.hoixuan.be_course_saling_web.model.Course;
import com.hoixuan.be_course_saling_web.repository.ICourseRepo;
import org.apache.commons.text.similarity.JaccardSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationService {
    @Autowired
    ICourseRepo iCourseRepo;


    public List<Course> recommend(Course targetCourse, int numRecommendations) {
        List<Course> allCourses = (List<Course>) iCourseRepo.findAll();
        JaccardSimilarity jaccardSimilarity = new JaccardSimilarity();
        List<Course> recommendedCourses = new ArrayList<>();

        for (Course course : allCourses) {
            if (!course.equals(targetCourse)) {
                double similarity = jaccardSimilarity.apply(course.getNameCourse(), targetCourse.getNameCourse())
                        + jaccardSimilarity.apply(course.getShortDescription(), targetCourse.getShortDescription())
                        + jaccardSimilarity.apply(course.getDescriptionCourse(), targetCourse.getDescriptionCourse());
                course.setSimilarityScore(similarity);
                recommendedCourses.add(course);
            }
        }

        // Sắp xếp các khóa học theo độ tương đồng giảm dần và lấy các khóa học hàng đầu
        recommendedCourses.sort((c1, c2) -> Double.compare(c2.getSimilarityScore(), c1.getSimilarityScore()));
        return recommendedCourses.subList(0, Math.min(numRecommendations, recommendedCourses.size()));
    }
}

