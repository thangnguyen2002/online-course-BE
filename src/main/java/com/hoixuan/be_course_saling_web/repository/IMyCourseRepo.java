package com.hoixuan.be_course_saling_web.repository;

import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.model.MyCourse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMyCourseRepo extends CrudRepository<MyCourse, Long> {
    @Query(nativeQuery = true,value = "select * from my_course where app_user_id_user = :idUser order by expire desc")
    List<MyCourse> findAllMyCourseById(@Param("idUser") long idUser);

    MyCourse findMyCourseByAppUserIdUserAndCourseIdCourse (long idUser, long idCourse);

    MyCourse findMyCourseByIdMyCourse (long idMyCourse);

    List<MyCourse> findAllByAppUserIdUserAndAndStatusMyCourse(long idUser,boolean isExpire);


}
