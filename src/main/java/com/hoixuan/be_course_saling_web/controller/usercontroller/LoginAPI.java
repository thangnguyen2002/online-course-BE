package com.hoixuan.be_course_saling_web.controller.usercontroller;
import com.hoixuan.be_course_saling_web.model.Role;
import com.hoixuan.be_course_saling_web.model.Wallet;
import com.hoixuan.be_course_saling_web.model.dto.*;
import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.service.AppUserService;
import com.hoixuan.be_course_saling_web.service.JwtService;
import com.hoixuan.be_course_saling_web.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@CrossOrigin("*")
public class LoginAPI {
    @Autowired
    JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    AppUserService appUserService;
    @Autowired
    WalletService walletService;

    private String email;



    @PostMapping("/login")
    public UserToken login(@RequestBody AccLogin accLogin) {
        try {
            // Tạo ra 1 đối tượng Authentication.
            AppUser appUser = appUserService.findByUserName(accLogin.getUserName());

            if (appUser.isStatus()){
                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(accLogin.getUserName(), accLogin.getPassword()));
                SecurityContextHolder.getContext().setAuthentication(authentication);
                String token = jwtService.createToken(authentication);
                AppUser appUser1 = appUserService.findByUserName(accLogin.getUserName());
                return new UserToken(appUser1.getIdUser(), appUser1.getUserName(), token, appUser1.getRoles());
            } else return null;

        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/register")
    public ResponseEntity<List<Boolean>> register(@RequestBody SignUpForm signUpForm) {
        List<Boolean> result = new ArrayList<>();
        AppUser appUserByEmail = appUserService.findByEMail(signUpForm.getEmail());
        AppUser appUserByName = appUserService.findByUserName(signUpForm.getUserName());
        boolean checkUserName = appUserByName == null;
        boolean checkMail = appUserByEmail == null;
        if (checkUserName && checkMail) {
            AppUser user = new AppUser();
            user.setUserName(signUpForm.getUserName());
            user.setEmail(signUpForm.getEmail());
            user.setPassword(signUpForm.getPassword());
            Set<Role> roleSet = new HashSet<>();
            Role role = new Role();
            role.setId(2);
            roleSet.add(role);
            user.setRoles(roleSet);
            appUserService.save(user);
            Wallet wallet = new Wallet();
            wallet.setMoney(0);
            wallet.setAppUser(user);
            walletService.save(wallet);
            result.add(true);
            result.add(true);
        } else {
            result.add(checkUserName);
            result.add(checkMail);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }





}
