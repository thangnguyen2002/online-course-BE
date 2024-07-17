package com.hoixuan.be_course_saling_web.controller.admincontroller;
import com.hoixuan.be_course_saling_web.model.ScoreQuiz;
import com.hoixuan.be_course_saling_web.service.ScoreQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class ScoreQuizAPI {
    @Autowired
    ScoreQuizService scoreQuizService;
    @GetMapping("/scorequiz/{id}")
    public ResponseEntity<List<ScoreQuiz>> getAll(@PathVariable(required = true) int id) {
        return  new ResponseEntity<>(scoreQuizService.getAllByIdQuiz(id), HttpStatus.OK);
    }
}
