package com.hoixuan.be_course_saling_web.controller.usercontroller;

import com.hoixuan.be_course_saling_web.model.*;
import com.hoixuan.be_course_saling_web.model.dto.LessonLearned;
import com.hoixuan.be_course_saling_web.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("*")
    @RequestMapping("/course")
public class MyCourseAPI {
    @Autowired
    AppUserService appUserService;

    @Autowired
    MyCourseService myCourseService;

    @Autowired
    CourseService courseService;
    @Autowired
    WalletService walletService;

    @Autowired
    BillService billService;


    @GetMapping("/myCourse")
    public ResponseEntity<List<MyCourse>> getAllMyCourseByUser() {
        List<MyCourse> myCourses = myCourseService.findAllMyCourseByIdUser(myCourseService.findIdUser());
        return new ResponseEntity<>(myCourses, HttpStatus.ACCEPTED);
    }

    @GetMapping("/myCourseLearn/{idCourse}")
    public ResponseEntity<MyCourse> getMyCourseLearn(@PathVariable long idCourse) {
        return new ResponseEntity<>(myCourseService.findMyCourseLearn(idCourse), HttpStatus.OK);
    }

    @PostMapping("/learned")
    public ResponseEntity<MyCourse> lessonLearned(@RequestBody LessonLearned lessonLearned) {
        LessonLearned a = lessonLearned;
        myCourseService.learned(lessonLearned.getIdMyCourse(), lessonLearned.getIdLesson());
        MyCourse myCourse = myCourseService.findMyCourseLearn(lessonLearned.getIdMyCourse());
        return new ResponseEntity<>(myCourse, HttpStatus.OK);
    }

    @GetMapping("/buyCourse/{idCourse}")
    public ResponseEntity<MyCourse> buyCourse(@PathVariable long idCourse) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Wallet wallet = walletService.findByIdUser(appUserService.findByUserName(userDetails.getUsername()).getIdUser());
        Course course = courseService.findById(idCourse);
        AppUser appUser = appUserService.findByUserName(userDetails.getUsername());
        Calendar cal = Calendar.getInstance();
        Date date=new Date(cal.getTimeInMillis());
        if(wallet.getMoney() >= course.getPriceCourse()){
            if (myCourseService.checkBuy(idCourse)){
                wallet.setMoney(wallet.getMoney()-course.getPriceCourse());
                MyCourse myCourse = myCourseService.findMyCourseLearn(idCourse);
                cal.add(Calendar.MONTH,course.getTimeCourse());
                Date date1=new Date(cal.getTimeInMillis());
                myCourse.setExpire(date1);
                myCourse.setStatusMyCourse(true);
                Bill bill = new Bill();
                bill.setCourse(course);
                bill.setAppUser(appUser);
                bill.setCreateAt(date);
                bill.setStatus(true);
                bill.setContentBill("Buy Course Again " + course.getNameCourse());
                bill.setPaymentMethod("Cash");
                bill.setTotalBill(course.getPriceCourse());
                billService.save(bill);
                return new ResponseEntity<>(myCourseService.save(myCourse),HttpStatus.OK);
            } else {
                wallet.setMoney(wallet.getMoney()-course.getPriceCourse());
                walletService.save(wallet);
                course.setEnrolled(course.getEnrolled() + 1);
                courseService.save(course);
                MyCourse myCourse = new MyCourse();
                myCourse.setCourse(course);
                myCourse.setAppUser(appUser);
                myCourse.setStatusMyCourse(true);
                Set<Lesson> lessonlist = new HashSet<>();
                myCourse.setLessonList(lessonlist);
                myCourse.setCompletionProgress(0);
                cal.add(Calendar.MONTH,course.getTimeCourse());
                Date dateExpire=new Date(cal.getTimeInMillis());
                myCourse.setExpire(dateExpire);
                Bill bill = new Bill();
                bill.setCourse(course);
                bill.setAppUser(appUser);
                bill.setContentBill("Buy Course " + course.getNameCourse());
                bill.setCreateAt(date);
                bill.setStatus(true);
                bill.setTotalBill(course.getPriceCourse());
                bill.setPaymentMethod("Cash");
                billService.save(bill);
                return new ResponseEntity<>(myCourseService.save(myCourse),HttpStatus.OK);
            }

        } else {
            Bill bill = new Bill();
            bill.setCourse(course);
            bill.setAppUser(appUser);
            bill.setCreateAt(date);
            bill.setStatus(false);
            bill.setTotalBill(course.getPriceCourse());
            bill.setContentBill("Buy Course " + course.getNameCourse());
            bill.setPaymentMethod("Cash");
            billService.save(bill);
            return new ResponseEntity(HttpStatus.OK);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Course> findById(@PathVariable(required = true) int id) {
        return new ResponseEntity<>(courseService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/{page}")
    public ResponseEntity<Page<Course>> getAll(@PathVariable(required = true) int page) {
        Page<Course> coursePage = courseService.getAll(PageRequest.of(page, 5, Sort.by("nameCourse")));
        return new ResponseEntity<>(coursePage, HttpStatus.OK);
    }

    @GetMapping("/trendingCourse")
    public ResponseEntity<List<Course>> getTrendingCourse() {
        return new ResponseEntity<>(courseService.getTrendingCourse(), HttpStatus.OK);
    }
    @GetMapping("/showUser")
    public List<AppUser> getRegister() {
        return appUserService.getAllUser();
    }
    @GetMapping("/checkExpire")
    public ResponseEntity<List<MyCourse>> checkExpire (){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = appUserService.findByUserName(userDetails.getUsername());
        List <MyCourse> myCourses= myCourseService.findAllMyCourseByIdUser(appUser.getIdUser());
        Calendar cal = Calendar.getInstance();
        Date date=new Date(cal.getTimeInMillis());
        for (MyCourse m: myCourses) {
            if(date.compareTo(m.getExpire()) > 0){
                m.setStatusMyCourse(false);
                myCourseService.save(m);
            }
        }
        return new ResponseEntity<>(myCourseService.findAllMyCourseByIdUser(appUser.getIdUser()),HttpStatus.OK);
    }
    @GetMapping("/checkBuy/{idCourse}")
    public ResponseEntity<Boolean> checkBuy(@PathVariable long idCourse){
        return new ResponseEntity<>(myCourseService.checkBuy(idCourse),HttpStatus.OK);
    }

    @GetMapping("/findExpired")
    public ResponseEntity<List<MyCourse>> findByExpired(){
        List<MyCourse> myCourses = myCourseService.findByExpire(false);
        return new ResponseEntity<>(myCourses, HttpStatus.OK);
    }

    @GetMapping("/findExpire")
    public ResponseEntity<List<MyCourse>> findByExpire(){
        List<MyCourse> myCourses = myCourseService.findByExpire(true);
        return new ResponseEntity<>(myCourses, HttpStatus.OK);
    }


}
