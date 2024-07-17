package com.hoixuan.be_course_saling_web.repository;

import com.hoixuan.be_course_saling_web.model.Quiz;
import org.springframework.data.repository.CrudRepository;

public interface IQuizRepo extends CrudRepository<Quiz, Long> {
    Quiz findByNameQuiz(String name);
}
