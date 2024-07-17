package com.hoixuan.be_course_saling_web.service;

import com.hoixuan.be_course_saling_web.model.Course;
import com.hoixuan.be_course_saling_web.model.TotalBillInMonth;
import com.hoixuan.be_course_saling_web.repository.ICourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    ICourseRepo iCourseRepo;
    public Page<Course>findAllByNameCourseContaining(Pageable pageable,String name){
        return iCourseRepo.findAllByNameCourseContaining(pageable,name);
    }
    public Page<Course> getAll(Pageable pageable){
        return iCourseRepo.findAll(pageable);
    }
    public Course findById(long id){
        return iCourseRepo.findById(id).get();
    }
    public Course save(Course course){
        return iCourseRepo.save(course);
    }

    public List<Course> getTrendingCourse (){
        return iCourseRepo.getTrendingCourse();
    }
    public List<Course> getAllCourseByCriteria (String nameCourse,int down,int up,int experience,String nameInstructor,int rating){
        return iCourseRepo.getAllCourseByCriteria(nameCourse,down,up,experience,nameInstructor,rating);
    }
    public List<Course> getAllNoPage(){
        return (List<Course>) iCourseRepo.findAll();
    }

    public Course findByIdCourse(long id){
        return iCourseRepo.findByIdCourse(id);
    }

    public Course findCourseNew (){
        return iCourseRepo.findCourseNew();
    }
}
