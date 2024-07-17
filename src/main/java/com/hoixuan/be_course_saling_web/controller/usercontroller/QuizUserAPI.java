package com.hoixuan.be_course_saling_web.controller.usercontroller;

import com.hoixuan.be_course_saling_web.model.Question;
import com.hoixuan.be_course_saling_web.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class QuizUserAPI {
    @Autowired
    QuestionService questionService;
    @GetMapping("/question/{id}")
    public ResponseEntity<List<Question>> getAll(@PathVariable(required = true) int id) {
        return  new ResponseEntity<>(questionService.findAllByIdQuiz(id), HttpStatus.OK);
    }
}
