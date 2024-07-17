package com.hoixuan.be_course_saling_web.repository;

import com.hoixuan.be_course_saling_web.model.Wallet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWalletRepo extends CrudRepository <Wallet,Long> {
    Wallet findWalletByAppUserIdUser(long idUser);
}
