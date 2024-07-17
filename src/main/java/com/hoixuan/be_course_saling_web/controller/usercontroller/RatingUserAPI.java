package com.hoixuan.be_course_saling_web.controller.usercontroller;


import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.model.Course;
import com.hoixuan.be_course_saling_web.model.MyCourse;
import com.hoixuan.be_course_saling_web.model.Rating;
import com.hoixuan.be_course_saling_web.model.dto.RatingCourse;
import com.hoixuan.be_course_saling_web.service.AppUserService;
import com.hoixuan.be_course_saling_web.service.CourseService;
import com.hoixuan.be_course_saling_web.service.MyCourseService;
import com.hoixuan.be_course_saling_web.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class RatingUserAPI {

    @Autowired
    RatingService ratingService;

    @Autowired
    AppUserService appUserService;

    @Autowired
    CourseService courseService;

    @Autowired
    MyCourseService myCourseService;

    @GetMapping("/getALlRating/{id}")
    public ResponseEntity<List<Rating>> getAllByCourse(@PathVariable long id) {
        return new ResponseEntity<>(ratingService.getAllByCourseIdAndStatus(id), HttpStatus.OK);
    }

    @PostMapping("/createRating/{idCourse}")
    public ResponseEntity<Rating> saveRating(@RequestBody Rating rating, @PathVariable long idCourse) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = appUserService.findByUserName(userDetails.getUsername());
        MyCourse myCourse = myCourseService.findByUserAndCourser(appUser.getIdUser(), idCourse);
        Optional<Rating> ratingOptional = ratingService.findRatingByAppUserIdUserAndCourseIdCourse(appUser.getIdUser(), myCourse.getCourse().getIdCourse());
        if (myCourse != null) {
            if (ratingOptional.isPresent()) {
                return new ResponseEntity<>(HttpStatus.OK);
            }
            rating.setAppUser(myCourse.getAppUser());
            rating.setCourse(myCourse.getCourse());
            rating.setStatusRating(true);
            Calendar cal = Calendar.getInstance();
            Date date=new Date(cal.getTimeInMillis());
            rating.setTimeRating(date);
            ratingService.save(rating);
            List<Rating> ratings = ratingService.getAllByCourseId(idCourse);
            int totalRating = 0;
            for (Rating r : ratings) {
                totalRating += r.getNumStar();
            }
            Course course = courseService.findByIdCourse(idCourse);
            course.setNumRating(totalRating / ratings.size());
            courseService.save(course);
            return new ResponseEntity<>(rating, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("/checkRated/{idCourse}")
    public ResponseEntity<Boolean> checkRated(@PathVariable long idCourse) {
        return new ResponseEntity<>(ratingService.checkRated(idCourse), HttpStatus.OK);
    }


}
