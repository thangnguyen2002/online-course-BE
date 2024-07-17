package com.hoixuan.be_course_saling_web.service;

import com.hoixuan.be_course_saling_web.model.Instructor;
import com.hoixuan.be_course_saling_web.repository.IInstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {
    @Autowired
    IInstructorRepo iInstructorRepo;
    public List<Instructor> getAll(){
        return (List<Instructor>) iInstructorRepo.findAll();
    }
    public Page<Instructor> getAllPage(Pageable pageable){
        return iInstructorRepo.findAll(pageable);
    }
    public Page<Instructor> getAllPageByName(Pageable pageable,String name){
        return iInstructorRepo.findAllByNameInstructorContaining(pageable,name);
    }
    public Instructor save(Instructor instructor){
        return iInstructorRepo.save(instructor);
    }
    public void delete(long id){
        iInstructorRepo.deleteById(id);
    }
}
