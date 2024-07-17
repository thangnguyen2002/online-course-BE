package com.hoixuan.be_course_saling_web.service;

import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.model.Role;
import com.hoixuan.be_course_saling_web.model.dto.DataMailDTO;
import com.hoixuan.be_course_saling_web.model.dto.SignUpForm;
import com.hoixuan.be_course_saling_web.repository.IAppUserRepo;
import com.hoixuan.be_course_saling_web.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.*;

@Service
public class AppUserService implements UserDetailsService {
    @Autowired
    IAppUserRepo iAppUserRepo;

    @Autowired
    MailService mailService;





    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = iAppUserRepo.findByUserNameS(username);
        return new User(appUser.getUserName(), appUser.getPassword(), appUser.getRoles());
    }
    public List<AppUser> getAll(){
        return (List<AppUser>) iAppUserRepo.findAll();
    }

    public AppUser findByUserName(String username){
        AppUser appUser = iAppUserRepo.findByUserName(username);
        return appUser;
    }
    public AppUser findById(long idUser){
        return iAppUserRepo.findById(idUser).get();
    }

    public AppUser findByEMail(String email){
        return iAppUserRepo.findByEmail(email);
    }

    public AppUser save(AppUser appUser){
//        try {
//            DataMailDTO dataMail = new DataMailDTO();
//
//            dataMail.setTo(appUser.getEmail());
//            dataMail.setSubject(Const.SEND_MAIL_SUBJECT.CLIENT_REGISTER);
//
//            Map<String, Object> props = new HashMap<>();
//            props.put("username", appUser.getUserName());
//            dataMail.setProps(props);
//
//            mailService.sendHtmlMail(dataMail, Const.TEMPLATE_FILE_NAME.CLIENT_REGISTER);
//        } catch (MessagingException exp){
//            exp.printStackTrace();
//        }
        return iAppUserRepo.save(appUser);
    }

    public void delete(long id){
     iAppUserRepo.deleteById(id);
    }
    public List<AppUser> getAllUser(){
        return iAppUserRepo.getAllAppUserUser();
    }




}
