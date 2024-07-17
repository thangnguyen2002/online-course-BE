package com.hoixuan.be_course_saling_web.service;

import com.hoixuan.be_course_saling_web.model.Quiz;
import com.hoixuan.be_course_saling_web.repository.IQuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService {
    @Autowired
    IQuizRepo iQuizRepo;

    public Quiz findByName(String name) {
        return iQuizRepo.findByNameQuiz(name);
    }

    public Quiz save(Quiz quiz) {
        return iQuizRepo.save(quiz);
    }

    public Quiz findById(long id) {
        return iQuizRepo.findById(id).get();
    }

}
