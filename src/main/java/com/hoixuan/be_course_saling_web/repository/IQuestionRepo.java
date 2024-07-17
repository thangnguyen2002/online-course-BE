package com.hoixuan.be_course_saling_web.repository;

import com.hoixuan.be_course_saling_web.model.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IQuestionRepo extends CrudRepository<Question,Long> {
    List<Question>findAllByQuiz_IdQuiz(long id);
}
