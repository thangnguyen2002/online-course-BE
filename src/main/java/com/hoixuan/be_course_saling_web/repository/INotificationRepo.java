package com.hoixuan.be_course_saling_web.repository;

import com.hoixuan.be_course_saling_web.model.Notification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface INotificationRepo extends CrudRepository<Notification,Long> {
    @Query(nativeQuery = true,value = "SELECT * FROM course_saling_web.notification where status=false and send_to=:send order by time_notification desc limit 5;")
    List<Notification> getNotificationNew(@Param("send") String send);
    List<Notification>findAllByAppUserUserNameAndStatusAndSendTo(String userName,boolean status,String sendTo);
}
