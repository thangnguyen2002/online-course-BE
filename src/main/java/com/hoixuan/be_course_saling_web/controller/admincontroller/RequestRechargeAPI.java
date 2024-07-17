package com.hoixuan.be_course_saling_web.controller.admincontroller;

import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.model.Bill;
import com.hoixuan.be_course_saling_web.model.RequestRecharge;
import com.hoixuan.be_course_saling_web.service.AppUserService;
import com.hoixuan.be_course_saling_web.service.BillService;
import com.hoixuan.be_course_saling_web.service.RequestRechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class RequestRechargeAPI {
    @Autowired
    AppUserService appUserService;
    @Autowired
    RequestRechargeService requestRechargeService;
    @Autowired
    BillService billService;


    @GetMapping("/requestRecharge")
    public ResponseEntity<List<RequestRecharge>> getAllRR (){
        return new ResponseEntity<>(requestRechargeService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/reqRechardUser")
    public ResponseEntity<List<RequestRecharge>> getAllByUser(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = appUserService.findByUserName(userDetails.getUsername());
        return new ResponseEntity<>(requestRechargeService.getAllByUser(appUser.getIdUser()),HttpStatus.OK);
    }
    @GetMapping("/deleteReq/{idReq}")
    public ResponseEntity<Bill> deleteReq (@PathVariable long idReq){
        Bill bill = new Bill();
        bill.setContentBill("Recharge");
        bill.setStatus(false);
        bill.setPaymentMethod("Banking");
        Calendar cal = Calendar.getInstance();
        Date date=new Date(cal.getTimeInMillis());
        bill.setCreateAt(date);
        RequestRecharge requestRecharge =requestRechargeService.findById(idReq);
        bill.setAppUser(requestRecharge.getAppUser());
        bill.setTotalBill(requestRecharge.getMoney());
        billService.save(bill);
        requestRechargeService.delete(idReq);
        return new ResponseEntity<>(billService.save(bill),HttpStatus.OK);
    }
    @GetMapping("/deleteRedUser/{idReq}")
    public ResponseEntity <RequestRecharge> deleteRedUser(@PathVariable long idReq){
        requestRechargeService.delete(idReq);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
