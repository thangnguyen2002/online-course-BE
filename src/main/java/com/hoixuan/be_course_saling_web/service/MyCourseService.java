package com.hoixuan.be_course_saling_web.service;

import com.hoixuan.be_course_saling_web.model.Lesson;
import com.hoixuan.be_course_saling_web.model.MyCourse;
import com.hoixuan.be_course_saling_web.repository.IMyCourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


@Service
public class MyCourseService {
    @Autowired
    IMyCourseRepo iMyCourseRepo;

    @Autowired
    AppUserService appUserService;
    @Autowired
    LessonService lessonService;


    public List<MyCourse> findAllMyCourseByIdUser(long idUser) {
        return iMyCourseRepo.findAllMyCourseById(idUser);
    }

    public long findIdUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return appUserService.findByUserName(userDetails.getUsername()).getIdUser();
    }

    public MyCourse findMyCourseLearn (long idCourse){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return iMyCourseRepo.findMyCourseByAppUserIdUserAndCourseIdCourse(appUserService.findByUserName(userDetails.getUsername()).getIdUser(),idCourse);
    }

    public MyCourse learned (long idMyCourse,long idLesson){
        Lesson lesson = lessonService.findById(idLesson);
        MyCourse myCourse = iMyCourseRepo.findMyCourseByIdMyCourse(idMyCourse);
        myCourse.getLessonList().add(lesson);
        iMyCourseRepo.save(myCourse);
        ArrayList<Lesson> lessonList = (ArrayList<Lesson>) lessonService.getAllByIdCourse(myCourse.getCourse().getIdCourse());
        if(myCourse.getLessonList().size() == 0){
            myCourse.setCompletionProgress(0);
        } else {
            double completionProgress = ((double) myCourse.getLessonList().size()) / ((double) lessonList.size()) * 100;
            DecimalFormat f = new DecimalFormat("##,00");

            myCourse.setCompletionProgress(completionProgress);
        }
        return iMyCourseRepo.save(myCourse);
    }
    public MyCourse save (MyCourse myCourse){
        return iMyCourseRepo.save(myCourse);
    }

  public MyCourse findByUserAndCourser(long idUser,long idCourse){
        return iMyCourseRepo.findMyCourseByAppUserIdUserAndCourseIdCourse(idUser, idCourse);
  }


    public boolean checkBuy(long idCourse){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        long idUser = appUserService.findByUserName(userDetails.getUsername()).getIdUser();
        MyCourse myCourse = iMyCourseRepo.findMyCourseByAppUserIdUserAndCourseIdCourse(idUser,idCourse);
        if (myCourse != null){
            return true;
        } else {
            return false;
        }
    }

    public List<MyCourse> findByExpire(Boolean isExpire){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        long idUser = appUserService.findByUserName(userDetails.getUsername()).getIdUser();
       return iMyCourseRepo.findAllByAppUserIdUserAndAndStatusMyCourse(idUser,isExpire);
    }
}
