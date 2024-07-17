package com.hoixuan.be_course_saling_web.repository;

import com.hoixuan.be_course_saling_web.model.Rating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface IRatingRepo extends PagingAndSortingRepository<Rating,Long> {
    Page<Rating> findAllByStatusRatingAndCourseNameCourseContaining(Pageable pageable,boolean status,String name);
    List<Rating> getAllByCourseIdCourse(long id);

    List<Rating> getAllByCourseIdCourseAndStatusRating(long id,boolean stattus);

    Optional<Rating> findRatingByAppUserIdUserAndCourseIdCourse(long idUser, long idCourse);





}
