package com.hoixuan.be_course_saling_web.service;

import com.hoixuan.be_course_saling_web.model.Bill;
import com.hoixuan.be_course_saling_web.model.TotalBillInMonth;
import com.hoixuan.be_course_saling_web.repository.IBillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {
    @Autowired
    IBillRepo iBillRepo;

    public Bill save (Bill bill){
        return iBillRepo.save(bill);
    }

    public List<Bill> getAll(){
        return (List<Bill>) iBillRepo.findAll();
    }

    public List <Bill> getAllByIdUser (long idUser){
        return iBillRepo.getBillsByAppUserIdUser(idUser);
    }

    public List <Bill> getAllByIdCourse (long idCourse){
        return iBillRepo.getBillsByCourseIdCourse(idCourse);
    }

    public Bill findById(long idBill){
        return iBillRepo.findById(idBill).get();
    }

    public TotalBillInMonth totalBillInMonth(long month){
        return iBillRepo.getTotalBillInMonth(month);
    }
}
