package com.hoixuan.be_course_saling_web.controller.admincontroller;

import com.hoixuan.be_course_saling_web.model.Course;
import com.hoixuan.be_course_saling_web.model.Quiz;
import com.hoixuan.be_course_saling_web.service.CourseService;
import com.hoixuan.be_course_saling_web.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class CourseAdminAPI {
    @Autowired
    CourseService courseService;
    @Autowired
    QuizService quizService;
    @GetMapping("/{page}")
    public ResponseEntity<Page<Course>> getAll(@PathVariable(required = true) int page) {
        Page<Course> coursePage = courseService.getAll(PageRequest.of(page, 5, Sort.by("nameCourse")));
        return  new ResponseEntity<>(coursePage, HttpStatus.OK);
    }
    @GetMapping("/{page}/{search}")
    public ResponseEntity<Page<Course>> getAllByName(@PathVariable(required = true) int page,@PathVariable(required = true) String search) {
        Page<Course> coursePage = courseService.findAllByNameCourseContaining(PageRequest.of(page, 5, Sort.by("nameCourse")),search);
        return  new ResponseEntity<>(coursePage, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Course> findById(@PathVariable(required = true) int id) {
      return new ResponseEntity<>(courseService.findById(id),HttpStatus.OK);
    }
    @PostMapping("/saveCourse")
    public ResponseEntity<Course> save(@RequestBody Course course) {
        String nameQuiz= "Quiz :"+ course.getNameCourse();
        Quiz quiz = new Quiz();
        quiz.setNameQuiz(nameQuiz);
        quiz.setNumberOfQuiz(0);
        quiz.setTimeQuiz(10);
        course.setStatusCourse(false);
        course.setQuiz(quizService.save(quiz));
        return new ResponseEntity<>(courseService.save(course),HttpStatus.OK);
    }
    @GetMapping("/disable/{id}")
    public ResponseEntity<Course> disable(@PathVariable(required = true) int id) {
       Course course= courseService.findById(id);
       course.setStatusCourse(false);
       return new ResponseEntity<>(courseService.save(course),HttpStatus.OK);
    }
    @GetMapping("/activated/{id}")
    public ResponseEntity<Course> activated(@PathVariable(required = true) int id) {
        Course course= courseService.findById(id);
        course.setStatusCourse(true);
        return new ResponseEntity<>(courseService.save(course),HttpStatus.OK);
    }
}
