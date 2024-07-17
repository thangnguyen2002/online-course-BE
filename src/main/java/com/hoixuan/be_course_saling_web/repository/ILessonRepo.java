package com.hoixuan.be_course_saling_web.repository;

import com.hoixuan.be_course_saling_web.model.Lesson;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ILessonRepo extends CrudRepository<Lesson,Long> {
    List<Lesson>getAllByCourseIdCourse(long id);
}
