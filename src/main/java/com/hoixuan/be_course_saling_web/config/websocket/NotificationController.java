package com.hoixuan.be_course_saling_web.config.websocket;

import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.model.Notification;
import com.hoixuan.be_course_saling_web.service.AppUserService;
import com.hoixuan.be_course_saling_web.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin("*")
public class NotificationController {
    @Autowired
    AppUserService appUserService;
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    NotificationService notificationService;
    @MessageMapping("/notification.send")
    public void sendMessage(@Payload Notification notification) {
        AppUser appUser = appUserService.findByUserName(notification.getAppUser().getUserName());
        notification.setAppUser(appUser);
       Notification nofSend = notificationService.save(notification);
       if (notification.getSendTo().equals("admin")){
           simpMessagingTemplate.convertAndSend("/notification/"+notification.getSendTo(), nofSend);
       }else {
           simpMessagingTemplate.convertAndSend("/notification/"+notification.getAppUser().getUserName(), nofSend);
       }
    }
}
