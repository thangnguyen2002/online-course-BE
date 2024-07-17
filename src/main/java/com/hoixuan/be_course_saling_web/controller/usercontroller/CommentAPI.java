package com.hoixuan.be_course_saling_web.controller.usercontroller;


import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.model.Comment;
import com.hoixuan.be_course_saling_web.model.Course;
import com.hoixuan.be_course_saling_web.model.dto.CommentCourse;
import com.hoixuan.be_course_saling_web.service.AppUserService;
import com.hoixuan.be_course_saling_web.service.CommentService;
import com.hoixuan.be_course_saling_web.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/comment")
public class CommentAPI {

    @Autowired
    CommentService commentService;

    @Autowired
    AppUserService appUserService;

    @Autowired
    CourseService courseService;


    @GetMapping("/getAllCmt/{idCourse}")
    public ResponseEntity<List<Comment>> getAllComment(@PathVariable long idCourse) {
        return new ResponseEntity<>(commentService.findByComment(idCourse), HttpStatus.OK);
    }

    @PostMapping("/createCmt/{id}")
    public ResponseEntity<Comment> createCmt(@PathVariable long id, @RequestBody CommentCourse commentCourse) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = appUserService.findByUserName(userDetails.getUsername());
        if (commentCourse.getContentCmt().equals("")) return null;
        Comment comments = new Comment();
        comments.setCourse(courseService.findByIdCourse(id));
        comments.setContentCmt(commentCourse.getContentCmt());
        comments.setTimeCmt(new Date());
        comments.setAppUser(appUser);
        commentService.saveCMT(comments);

        return new ResponseEntity<>(comments, HttpStatus.CREATED);
    }

    @PostMapping("/editCmt/{idCmt}")
    public ResponseEntity<Comment> editCmt(@PathVariable long idCmt, @RequestBody Comment comment) {
            comment.setIdComment(idCmt);
            comment.setTimeCmt(commentService.findById(idCmt).getTimeCmt());
            comment = commentService.saveCMT(comment);
            return new ResponseEntity<>(comment, HttpStatus.OK);
        }

    @GetMapping("/deleteCmt/{id}")
    public ResponseEntity<Comment> deleteCmt(@PathVariable long id) {
        commentService.deleteCMT(id);
        return new ResponseEntity<>(new Comment(), HttpStatus.OK);
    }

    @GetMapping("/findByID/{id}")
    public ResponseEntity<Comment> findCmtByID (@PathVariable long id) {
        return new ResponseEntity<>(commentService.findById(id), HttpStatus.OK);
    }


}
