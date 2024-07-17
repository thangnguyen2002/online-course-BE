package com.hoixuan.be_course_saling_web.service;

import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.model.ScoreQuiz;
import com.hoixuan.be_course_saling_web.repository.IScoreQuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreQuizService {
    @Autowired
    IScoreQuizRepo iScoreQuizRepo;

    public List<ScoreQuiz> getAllByIdQuiz(long id) {
        return iScoreQuizRepo.findAllByQuiz_IdQuiz(id);
    }

    public ScoreQuiz save(ScoreQuiz scoreQuiz) {
        return iScoreQuizRepo.save(scoreQuiz);
    }

    public List<ScoreQuiz> getAllByUser(long idQuiz,long idUser){
        return iScoreQuizRepo.findAllByAppUserIdUserAndQuizIdQuiz(idUser,idQuiz);
    }
}
