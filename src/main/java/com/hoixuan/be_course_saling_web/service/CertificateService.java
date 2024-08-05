package com.hoixuan.be_course_saling_web.service;

import com.hoixuan.be_course_saling_web.model.Certificate;
import com.hoixuan.be_course_saling_web.model.dto.DataMailDTO;
import com.hoixuan.be_course_saling_web.repository.IAppUserRepo;
import com.hoixuan.be_course_saling_web.repository.ICertificateRepo;
import com.hoixuan.be_course_saling_web.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CertificateService {
    @Autowired
    IAppUserRepo iAppUserRepo;

    @Autowired
    MailService mailService;

    @Autowired
    ICertificateRepo iCertificateRepo;
    public Certificate save (Certificate certificate) throws MessagingException {
        DataMailDTO dataMail = new DataMailDTO();
        dataMail.setTo(certificate.getAppUser().getEmail());
        dataMail.setSubject(Const.SEND_MAIL_SUBJECT.CLIENT_CERTIFICATE);
        Map<String, Object> props = new HashMap<>();
        props.put("username", certificate.getAppUser().getUserName());
        dataMail.setProps(props);
        mailService.sendHtmlMail(dataMail, Const.TEMPLATE_FILE_NAME.CLIENT_CERTIFICATE);
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
