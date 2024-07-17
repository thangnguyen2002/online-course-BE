package com.hoixuan.be_course_saling_web.controller.admincontroller;

import com.hoixuan.be_course_saling_web.model.Course;
import com.hoixuan.be_course_saling_web.model.Rating;
import com.hoixuan.be_course_saling_web.service.CourseService;
import com.hoixuan.be_course_saling_web.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class RatingAdminAPI {
    @Autowired
    RatingService ratingService;
    @Autowired
    CourseService courseService;
    @GetMapping("/rating/{id}")
    public ResponseEntity<List<Rating>>getAllByIdCourse(@PathVariable long id){
        return new ResponseEntity<>(ratingService.getAllByCourseId(id), HttpStatus.OK);
    }
    @GetMapping("/rating/approval/{id}")
    public Rating approvalById(@PathVariable long id){
        Rating rating = ratingService.findById(id);
        rating.setStatusRating(true);
        return ratingService.save(rating);
    }
    @GetMapping("/rating/disable/{id}")
    public Rating disable(@PathVariable long id){
        Rating rating = ratingService.findById(id);
        rating.setStatusRating(false);
        return ratingService.save(rating);
    }
    @GetMapping("/rating/delete/{id}")
    public Rating deleteById(@PathVariable long id){
        Rating rating = ratingService.findById(id);
        Course course = courseService.findByIdCourse(rating.getCourse().getIdCourse());
        ratingService.delete(id);
        List<Rating> ratings = ratingService.getAllByCourseId(rating.getCourse().getIdCourse());
        int totalRating = 0;
        for (Rating r : ratings) {
            totalRating += r.getNumStar();
        }
        if (totalRating == 0) {
            course.setNumRating(5);
        }else {
            course.setNumRating(totalRating / ratings.size());
        }

        courseService.save(course);
        return new Rating();
    }
    @GetMapping("/allRating/{page}")
    public ResponseEntity<Page<Rating>>getAllFalse(@PathVariable int page){
        Page<Rating> ratings = ratingService.getAll(PageRequest.of(page, 5,Sort.by("timeRating").ascending()));
        return  new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    @GetMapping("/allRating/{page}/{search}")
    public ResponseEntity<Page<Rating>>getAllFalseByNameCourse(@PathVariable int page,@PathVariable String search){
        Page<Rating> ratings = ratingService.getAllByStatusAndNameCourse(PageRequest.of(page, 5,Sort.by("timeRating").ascending()),false,search);
        return  new ResponseEntity<>(ratings, HttpStatus.OK);
    }
}
