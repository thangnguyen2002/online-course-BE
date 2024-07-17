package com.hoixuan.be_course_saling_web.controller.usercontroller;

import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.model.Bill;
import com.hoixuan.be_course_saling_web.model.TotalBillInMonth;
import com.hoixuan.be_course_saling_web.service.AppUserService;
import com.hoixuan.be_course_saling_web.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/bill")
public class BillUserAPI {
    @Autowired
    BillService billService;
    @Autowired
    AppUserService appUserService;


    @GetMapping("/billUser")
    public ResponseEntity<List<Bill>> getAllUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = appUserService.findByUserName(userDetails.getUsername());
        return new ResponseEntity<>(billService.getAllByIdUser(appUser.getIdUser()), HttpStatus.OK);
    }

    @GetMapping("/allBill")
    public ResponseEntity<List<Bill>> getAll() {
        return new ResponseEntity<>(billService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/billCourse/{idCourse}")
    public ResponseEntity<List<Bill>> getAllBillByCourse(@PathVariable long idCourse) {
        return new ResponseEntity<>(billService.getAllByIdCourse(idCourse), HttpStatus.OK);
    }
    @GetMapping("/totalBillInMonth")
    public ResponseEntity<TotalBillInMonth> getTotalBillInMonth(){
        int date = new Date().getMonth() + 1;
        return new ResponseEntity<>(billService.totalBillInMonth(date),HttpStatus.OK);
    }
}
