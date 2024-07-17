package com.hoixuan.be_course_saling_web.service;
import com.hoixuan.be_course_saling_web.model.Rating;
import com.hoixuan.be_course_saling_web.repository.IRatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {
    @Autowired
    AppUserService appUserService;
    final
    IRatingRepo iRatingRepo;
    public Page<Rating> getAll(Pageable pageable){
        return iRatingRepo.findAll(pageable);
    }
    public Page<Rating> getAllByStatusAndNameCourse(Pageable pageable,boolean status,String name){
        return iRatingRepo.findAllByStatusRatingAndCourseNameCourseContaining(pageable,status,name);
    }
    public RatingService(IRatingRepo iRatingRepo) {
        this.iRatingRepo = iRatingRepo;
    }
    public List<Rating> getAllByCourseId(long id){
        return iRatingRepo.getAllByCourseIdCourse(id);
    }

    public List<Rating>getAllByCourseIdAndStatus(long id){
        return iRatingRepo.getAllByCourseIdCourseAndStatusRating(id,true);
    }
    public Rating findById(long id){
        return iRatingRepo.findById(id).get();
    }
    public Rating save(Rating rating){
        return iRatingRepo.save(rating);
    }
    public void delete(long id){
        iRatingRepo.deleteById(id);
    }

    public Optional<Rating> findRatingByAppUserIdUserAndCourseIdCourse(long idUser, long idCourse){
       return iRatingRepo.findRatingByAppUserIdUserAndCourseIdCourse(idUser, idCourse);

    }

    public boolean checkRated(long idCourse){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        long idUser = appUserService.findByUserName(userDetails.getUsername()).getIdUser();
       Optional <Rating> rating = iRatingRepo.findRatingByAppUserIdUserAndCourseIdCourse(idUser, idCourse);
       if (rating.isPresent()){
           return false;
       }else {
           return true;
       }
    }
}
