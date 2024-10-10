package com.hoixuan.be_course_saling_web.controller.usercontroller;

import com.hoixuan.be_course_saling_web.config.filter.JwtAuthenticationFilter;
import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.model.dto.ChangeAvatar;
import com.hoixuan.be_course_saling_web.model.dto.ChangePassword;
import com.hoixuan.be_course_saling_web.model.dto.ChangeProfileUser;
import com.hoixuan.be_course_saling_web.service.AppUserService;
import com.hoixuan.be_course_saling_web.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserAPI {

    @Autowired
    AppUserService appUserService;

    @Autowired
    JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("")
    public ResponseEntity<AppUser> getProfile (){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser =appUserService.findByUserName(userDetails.getUsername());
        return new ResponseEntity<AppUser>(appUser,HttpStatus.OK);
    }

    @PostMapping("/change-profile")
    public ResponseEntity<AppUser> changeProfile(@RequestBody ChangeProfileUser changeProfileUser){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser =appUserService.findByUserName(userDetails.getUsername());

        appUser.setFullName(changeProfileUser.getFullName());
        appUser.setAddress(changeProfileUser.getAddress());
        appUser.setDateOfBirth(changeProfileUser.getDateOfBirth());
        appUser.setPhone(changeProfileUser.getPhone());
        appUser.setDescription(changeProfileUser.getDescription());
        appUser.setUserName(changeProfileUser.getUserName());
        appUser.setEmail(changeProfileUser.getEmail());
        appUserService.save(appUser);
        return new ResponseEntity<>(appUser, HttpStatus.OK);
    }

    @PostMapping("/change-avatar")
    public ResponseEntity<AppUser> changeAvatar(@RequestBody ChangeAvatar changeAvatar){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = appUserService.findByUserName(userDetails.getUsername());
        appUser.setAvatarSrc(changeAvatar.getAvatar());
        appUserService.save(appUser);
        return new ResponseEntity<>(appUser, HttpStatus.OK);
    }
    @PostMapping("/change-password")
    public ResponseEntity<AppUser> changePassword(@RequestBody ChangePassword changePassword) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = appUserService.findByUserName(userDetails.getUsername());
        String newPassword;
        String oldPassword = changePassword.getOldPassword();
//        if (oldPassword.equals(appUser.getPassword())) {
//            if (changePassword.getNewPassword().equals(changePassword.getConfirmNewPassword())) {
//                newPassword = changePassword.getNewPassword();
//            } else {
//                return new ResponseEntity<>(HttpStatus.OK);
//            }
//        } else {
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        appUser.setPassword(newPassword);
//        appUserService.save(appUser);
//        return new ResponseEntity<>(appUser, HttpStatus.OK);

        // So sánh mật khẩu cũ nhập vào với mật khẩu đã mã hóa trong cơ sở dữ liệu
        if (passwordEncoder.matches(oldPassword, appUser.getPassword())) {
            // Kiểm tra xem mật khẩu mới và xác nhận mật khẩu mới có khớp nhau hay không
            if (changePassword.getNewPassword().equals(changePassword.getConfirmNewPassword())) {
                // Mã hóa mật khẩu mới trước khi lưu
                newPassword = passwordEncoder.encode(changePassword.getNewPassword());
                appUser.setPassword(newPassword);
                appUserService.save(appUser);
                return new ResponseEntity<>(appUser, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Mật khẩu mới và xác nhận mật khẩu không khớp
            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Mật khẩu cũ không đúng
        }
    }

    @DeleteMapping("/delete-account/{idUser}")
    public ResponseEntity<AppUser> deleteAccount(@PathVariable long idUser){
        appUserService.delete(idUser);
        return new ResponseEntity<>(new AppUser(), HttpStatus.OK);
    }

}
