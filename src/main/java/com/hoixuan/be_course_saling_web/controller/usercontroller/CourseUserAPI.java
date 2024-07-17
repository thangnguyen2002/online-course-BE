package com.hoixuan.be_course_saling_web.controller.usercontroller;

import com.hoixuan.be_course_saling_web.model.Course;
import com.hoixuan.be_course_saling_web.model.Instructor;
import com.hoixuan.be_course_saling_web.model.dto.Criteria;
import com.hoixuan.be_course_saling_web.service.CourseService;
import com.hoixuan.be_course_saling_web.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class CourseUserAPI {
    @Autowired
    CourseService courseService;
    @Autowired
    InstructorService instructorService;

    @PostMapping("/courseCriteria")
    public List<Course> getAllCourseByCriteria(@RequestBody Criteria criteria){
        criteria.setNameCourse("%"+criteria.getNameCourse()+"%");
        criteria.setNameInstructor("%"+criteria.getNameInstructor()+"%");
        if(criteria.getFrom() > criteria.getTo()){
            return courseService.getAllCourseByCriteria(criteria.getNameCourse(),criteria.getTo(), criteria.getFrom(),criteria.getExperience(), criteria.getNameInstructor(), criteria.getRating());
        } else{
            return courseService.getAllCourseByCriteria(criteria.getNameCourse(),criteria.getFrom(), criteria.getTo(),criteria.getExperience(), criteria.getNameInstructor(), criteria.getRating());

        }
    }
    @GetMapping("/allCourse")
    public ResponseEntity<List<Course>> getAll(){
        return new ResponseEntity<>(courseService.getAllNoPage(), HttpStatus.OK);
    }
    @GetMapping("/allInstructor")
    public ResponseEntity<List<Instructor>> getAllInStructor(){
        return new ResponseEntity<>(instructorService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/courseNew")
    public ResponseEntity<Course> getCourseNew(){
        return new ResponseEntity<>(courseService.findCourseNew(),HttpStatus.OK);
    }

}
