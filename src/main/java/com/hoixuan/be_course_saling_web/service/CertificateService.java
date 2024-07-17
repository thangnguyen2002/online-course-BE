package com.hoixuan.be_course_saling_web.service;

import com.hoixuan.be_course_saling_web.model.Certificate;
import com.hoixuan.be_course_saling_web.repository.ICertificateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateService {
    @Autowired
    ICertificateRepo iCertificateRepo;
    public Certificate save (Certificate certificate){
        return iCertificateRepo.save(certificate);
    }

    public List<Certificate> getAll (){
        return (List<Certificate>) iCertificateRepo.findAll();
    }

    public List<Certificate> findById(long idUser){
        return iCertificateRepo.findAllByAppUserIdUser(idUser);
    }
    public Certificate findByUserAndCourse(long idUser,long idCourse){
        return iCertificateRepo.findByAppUserIdUserAndCourseIdCourse(idUser,idCourse);
    }
}
