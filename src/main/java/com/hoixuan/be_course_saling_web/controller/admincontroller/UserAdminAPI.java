package com.hoixuan.be_course_saling_web.controller.admincontroller;

import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class UserAdminAPI {
    @Autowired
    AppUserService appUserService;


    @GetMapping("/disableUser/{idUser}")
    public ResponseEntity<AppUser> disableUser(@PathVariable(required = true) long idUser){
        AppUser appUser = appUserService.findById(idUser);
        appUser.setStatus(false);
        return new ResponseEntity<>(appUserService.save(appUser), HttpStatus.OK);
    }
    @GetMapping("/activatedUser/{idUser}")
    public ResponseEntity<AppUser> activatedUser(@PathVariable(required = true) long idUser) {
        AppUser appUser= appUserService.findById(idUser);
        appUser.setStatus(true);
        return new ResponseEntity<>(appUserService.save(appUser),HttpStatus.OK);
    }
}
