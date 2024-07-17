package com.hoixuan.be_course_saling_web.controller.usercontroller;

import com.hoixuan.be_course_saling_web.model.Instructor;
import com.hoixuan.be_course_saling_web.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class InstructorAPI {
    @Autowired
    InstructorService instructorService;

    @GetMapping("/instructor")
    public ResponseEntity<List<Instructor>> findAllInstructor(){
        return new ResponseEntity<>(instructorService.getAll(), HttpStatus.OK) ;
    }
}
