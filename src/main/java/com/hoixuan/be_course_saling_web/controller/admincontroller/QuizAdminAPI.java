package com.hoixuan.be_course_saling_web.controller.admincontroller;
import com.hoixuan.be_course_saling_web.model.Question;
import com.hoixuan.be_course_saling_web.model.Quiz;
import com.hoixuan.be_course_saling_web.service.QuestionService;
import com.hoixuan.be_course_saling_web.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class QuizAdminAPI {
    @Autowired
    QuizService quizService;
    @Autowired
    QuestionService questionService;
    @GetMapping("/question/{id}")
    public ResponseEntity<List<Question>> getAll(@PathVariable(required = true) int id) {
        return  new ResponseEntity<>(questionService.findAllByIdQuiz(id), HttpStatus.OK);
    }
    @PostMapping("/question/{id}")
    public ResponseEntity<Question> save(@PathVariable long id, @RequestBody Question question) {
       question.setQuiz(quizService.findById(id));
        return new ResponseEntity<>(questionService.save(question), HttpStatus.OK);
    }
    @PostMapping("/quiz/{id}")
    public ResponseEntity<Quiz> saveQuiz(@PathVariable long id, @RequestBody Quiz quiz) {
        return new ResponseEntity<>(quizService.save(quiz), HttpStatus.OK);
    }
    @GetMapping("/question/delete/{id}")
    public ResponseEntity<Question> delete(@PathVariable(required = true) int id) {
        questionService.deleteById(id);
        return  new ResponseEntity<>(new Question(), HttpStatus.OK);
    }
}
