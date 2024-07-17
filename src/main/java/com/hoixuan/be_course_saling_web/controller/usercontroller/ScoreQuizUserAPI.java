package com.hoixuan.be_course_saling_web.controller.usercontroller;
import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.model.ScoreQuiz;
import com.hoixuan.be_course_saling_web.service.AppUserService;
import com.hoixuan.be_course_saling_web.service.ScoreQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/scorequiz")
public class ScoreQuizUserAPI {
    @Autowired
    ScoreQuizService scoreQuizService;
    @Autowired
    AppUserService appUserService;
    @PostMapping("/save")
    public ResponseEntity<ScoreQuiz> save( @RequestBody ScoreQuiz scoreQuiz) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = appUserService.findByUserName(userDetails.getUsername());
        scoreQuiz.setAppUser(appUser);
        return new ResponseEntity<>(scoreQuizService.save(scoreQuiz), HttpStatus.OK);
    }
    @GetMapping("/allUser/{idQuiz}")
    public ResponseEntity<List<ScoreQuiz>> getAllQuizUser(@PathVariable long idQuiz){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = appUserService.findByUserName(userDetails.getUsername());
        return new ResponseEntity<>(scoreQuizService.getAllByUser(idQuiz,appUser.getIdUser()),HttpStatus.OK);
    }

}
