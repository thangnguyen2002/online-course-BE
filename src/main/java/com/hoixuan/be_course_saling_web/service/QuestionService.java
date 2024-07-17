package com.hoixuan.be_course_saling_web.service;

import com.hoixuan.be_course_saling_web.model.Question;
import com.hoixuan.be_course_saling_web.repository.IQuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    IQuestionRepo iQuestionRepo;

    public List<Question> findAllByIdQuiz(long id) {
        return iQuestionRepo.findAllByQuiz_IdQuiz(id);
    }

    public Question save(Question question) {
        return iQuestionRepo.save(question);
    }

    public void deleteById(long id) {
        iQuestionRepo.deleteById(id);
    }
}
