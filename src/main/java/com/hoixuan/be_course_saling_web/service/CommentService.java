package com.hoixuan.be_course_saling_web.service;

import com.hoixuan.be_course_saling_web.model.Comment;
import com.hoixuan.be_course_saling_web.repository.ICommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    ICommentRepo iCommentRepo;


    public List<Comment> findByComment(long idCourse) {
        return iCommentRepo.findAllByCourseIdCourse(idCourse);
    }

    public Comment saveCMT(Comment comment) {
        return iCommentRepo.save(comment);
    }

    public Comment findById(Long id){
        return iCommentRepo.findById(id).get();
    }

    public void deleteCMT(long idCmt){
        iCommentRepo.deleteById(idCmt);
    }



}
