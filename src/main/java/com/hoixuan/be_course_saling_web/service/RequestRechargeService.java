package com.hoixuan.be_course_saling_web.service;

import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.model.RequestRecharge;
import com.hoixuan.be_course_saling_web.repository.IRequestRechargeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class RequestRechargeService {
    @Autowired
    IRequestRechargeRepo iRequestRechargeRepo;
    @Autowired
    AppUserService appUserService;

    public RequestRecharge findById(long idReq){
        return iRequestRechargeRepo.findByIdRequest(idReq);
    }
    public List<RequestRecharge> getAll() {
        return (List<RequestRecharge>) iRequestRechargeRepo.findAll();
    }
    public void delete(long idReq){
        iRequestRechargeRepo.deleteById(idReq);
    }
    public RequestRecharge save (RequestRecharge requestRecharge){
        return iRequestRechargeRepo.save(requestRecharge);
    }
    public List<RequestRecharge> getAllByUser (long idUser){
        return iRequestRechargeRepo.findByAppUserIdUser(idUser);
    }
}
