package com.hoixuan.be_course_saling_web.repository;

import com.hoixuan.be_course_saling_web.model.Certificate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICertificateRepo extends CrudRepository<Certificate,Long> {
    List<Certificate> findAllByAppUserIdUser (long idUser);

    Certificate findByAppUserIdUserAndCourseIdCourse (long idUser,long idCourse);
}
