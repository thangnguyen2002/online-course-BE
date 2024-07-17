package com.hoixuan.be_course_saling_web.repository;

import com.hoixuan.be_course_saling_web.model.ScoreQuiz;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IScoreQuizRepo extends CrudRepository<ScoreQuiz,Long> {
    List<ScoreQuiz> findAllByQuiz_IdQuiz(long id);
    List<ScoreQuiz> findAllByAppUserIdUserAndQuizIdQuiz(long idUser,long idQuiz);
}
