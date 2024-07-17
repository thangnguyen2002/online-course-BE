package com.hoixuan.be_course_saling_web.controller.usercontroller;

import com.hoixuan.be_course_saling_web.model.Lesson;
import com.hoixuan.be_course_saling_web.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/lesson")
public class LessonAPI {
    @Autowired
    LessonService lessonService;

    @GetMapping("/{id}")
    public ResponseEntity <List<Lesson>> getAllLessonById(@PathVariable long id){
        return new ResponseEntity<>(lessonService.getAllByIdCourse(id), HttpStatus.OK);
    }
}
