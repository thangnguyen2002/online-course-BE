package com.hoixuan.be_course_saling_web.service;

import com.hoixuan.be_course_saling_web.model.Wallet;
import com.hoixuan.be_course_saling_web.repository.IWalletRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
    @Autowired
    IWalletRepo iWalletRepo;

    public Wallet save (Wallet wallet){
        return iWalletRepo.save(wallet);
    }

    public Wallet findById (long idWallet){
        return iWalletRepo.findById(idWallet).get();
    }

    public Wallet findByIdUser(long idUser){
        return iWalletRepo.findWalletByAppUserIdUser(idUser);
    }
}
