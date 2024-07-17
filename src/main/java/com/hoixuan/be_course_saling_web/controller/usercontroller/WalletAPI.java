package com.hoixuan.be_course_saling_web.controller.usercontroller;

import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.model.Bill;
import com.hoixuan.be_course_saling_web.model.RequestRecharge;
import com.hoixuan.be_course_saling_web.model.Wallet;
import com.hoixuan.be_course_saling_web.model.dto.Money;
import com.hoixuan.be_course_saling_web.model.dto.Recharge;
import com.hoixuan.be_course_saling_web.service.AppUserService;
import com.hoixuan.be_course_saling_web.service.BillService;
import com.hoixuan.be_course_saling_web.service.RequestRechargeService;
import com.hoixuan.be_course_saling_web.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Calendar;

@RestController
@CrossOrigin("*")
@RequestMapping("/wallet")
public class WalletAPI {
    @Autowired
    WalletService walletService;
    @Autowired
    AppUserService appUserService;
    @Autowired
    BillService billService;
    @Autowired
    RequestRechargeService requestRechargeService;
    @PostMapping("/recharge")
    public ResponseEntity<Wallet> recharge(@RequestBody Recharge recharge){
        Wallet wallet = walletService.findByIdUser(recharge.getIdUser());
        wallet.setMoney(wallet.getMoney() + recharge.getMoney());
        requestRechargeService.delete(recharge.getIdReq());
        Bill bill = new Bill();
        bill.setPaymentMethod("Banking");
        bill.setContentBill("Recharge");
        bill.setTotalBill(recharge.getMoney());
        bill.setStatus(true);
        Calendar cal = Calendar.getInstance();
        Date date=new Date(cal.getTimeInMillis());
        bill.setCreateAt(date);
        AppUser appUser = appUserService.findById(recharge.getIdUser());
        bill.setAppUser(appUser);
        billService.save(bill);
        return new ResponseEntity<>(walletService.save(wallet), HttpStatus.OK);
    }
    @PostMapping("/reqRecharge")
    public ResponseEntity<RequestRecharge> reqRecharge(@RequestBody Money money){
        RequestRecharge requestRecharge = new RequestRecharge();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = appUserService.findByUserName(userDetails.getUsername());
        requestRecharge.setAppUser(appUser);
        requestRecharge.setMoney(money.getMoney());
        Calendar cal = Calendar.getInstance();
        Date date=new Date(cal.getTimeInMillis());
        requestRecharge.setCreateAt(date);
        requestRecharge.setStatus(true);
        requestRecharge.setPaymentMethod("Banking");
        return new ResponseEntity<>(requestRechargeService.save(requestRecharge),HttpStatus.OK);
    }
    @GetMapping ("")
    public ResponseEntity<Wallet> getWalletByUser (){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = appUserService.findByUserName(userDetails.getUsername());
        return new ResponseEntity<>(walletService.findByIdUser(appUser.getIdUser()),HttpStatus.OK);
    }
}
