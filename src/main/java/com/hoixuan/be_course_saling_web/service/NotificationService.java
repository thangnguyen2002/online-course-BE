package com.hoixuan.be_course_saling_web.service;

import com.hoixuan.be_course_saling_web.model.Notification;
import com.hoixuan.be_course_saling_web.repository.INotificationRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    final
    INotificationRepo iNotificationRepo;

    public NotificationService(INotificationRepo iNotificationRepo) {
        this.iNotificationRepo = iNotificationRepo;
    }
    public List<Notification> getNewNotification(String sendTo){
        return iNotificationRepo.getNotificationNew(sendTo);
    }
    public List<Notification> getNewNotificationUser(boolean status,String sendTo,String name){
        return iNotificationRepo.findAllByAppUserUserNameAndStatusAndSendTo(name,status,sendTo);
    }
    public Notification save(Notification notification){
        return iNotificationRepo.save(notification);
    }
    public Notification findById(long id){
        return iNotificationRepo.findById(id).get();
    }
}
