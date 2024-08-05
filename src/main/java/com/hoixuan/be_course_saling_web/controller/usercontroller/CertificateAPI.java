package com.hoixuan.be_course_saling_web.controller.usercontroller;

import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.model.Certificate;
import com.hoixuan.be_course_saling_web.model.MyCourse;
import com.hoixuan.be_course_saling_web.model.dto.CertificateDTO;
import com.hoixuan.be_course_saling_web.service.AppUserService;
import com.hoixuan.be_course_saling_web.service.CertificateService;
import com.hoixuan.be_course_saling_web.service.CourseService;
import com.hoixuan.be_course_saling_web.service.MyCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("user")
public class CertificateAPI {
    @Autowired
    CertificateService certificateService;
    @Autowired
    AppUserService appUserService;
    @Autowired
    CourseService courseService;
    @Autowired
    MyCourseService myCourseService;
    @GetMapping("/certificate")
    public ResponseEntity<List<Certificate>> getAll(){
        return new ResponseEntity<>(certificateService.getAll(), HttpStatus.OK);
    }
    @PostMapping("/save-certificate")
    public ResponseEntity<Certificate> saveCertificate(@RequestBody CertificateDTO certificateDTO) throws MessagingException {
        Certificate certificate = new Certificate();
        certificate.setImageCertificate(certificateDTO.getImg());
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = appUserService.findByUserName(userDetails.getUsername());
        certificate.setAppUser(appUser);
        certificate.setCourse(courseService.findByIdCourse(certificateDTO.getIdCourse()));
        certificate.setCreateAt(certificateDTO.getCreateAt());
        MyCourse myCourse = myCourseService.findByUserAndCourser(appUser.getIdUser(),courseService.findByIdCourse(certificateDTO.getIdCourse()).getIdCourse());
        myCourse.setCertificate(certificate);
        return new ResponseEntity<>(certificateService.save(certificate),HttpStatus.OK);
    }

    @GetMapping("/cerUser")
    public ResponseEntity<List<Certificate>> findAllById(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = appUserService.findByUserName(userDetails.getUsername());
        return new ResponseEntity<>(certificateService.findById(appUser.getIdUser()),HttpStatus.OK);
    }
    @GetMapping("/findCer/{idCourse}")
    public ResponseEntity<Certificate> findCer(@PathVariable long idCourse){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = appUserService.findByUserName(userDetails.getUsername());
        return new ResponseEntity<>(certificateService.findByUserAndCourse(appUser.getIdUser(),idCourse),HttpStatus.OK);
    }

}

