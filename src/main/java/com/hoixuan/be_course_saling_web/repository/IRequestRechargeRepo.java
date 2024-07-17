package com.hoixuan.be_course_saling_web.repository;

import com.hoixuan.be_course_saling_web.model.RequestRecharge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRequestRechargeRepo extends CrudRepository<RequestRecharge,Long> {
    @Query(nativeQuery = true,value = "select * from request_recharge where app_user_id_user = :idUser order by create_at desc")
    List<RequestRecharge> findByAppUserIdUser(@Param("idUser") long idUser);
    @Query(nativeQuery = true,value = "select * from request_recharge order by create_at desc ")
    List<RequestRecharge> getAll ();

    RequestRecharge findByIdRequest(long idReq);
}
