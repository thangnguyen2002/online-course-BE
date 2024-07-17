package com.hoixuan.be_course_saling_web.model.dto;

public class LessonLearned {
    long idMyCourse;
    long idLesson;

    public LessonLearned(long idMyCourse, long idLesson) {
        this.idMyCourse = idMyCourse;
        this.idLesson = idLesson;
    }

    public long getIdMyCourse() {
        return idMyCourse;
    }

    public void setIdMyCourse(long idMyCourse) {
        this.idMyCourse = idMyCourse;
    }

    public long getIdLesson() {
        return idLesson;
    }

    public void setIdLesson(long idLesson) {
        this.idLesson = idLesson;
    }
}
