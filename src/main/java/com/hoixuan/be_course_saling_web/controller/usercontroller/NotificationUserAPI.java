package com.hoixuan.be_course_saling_web.controller.usercontroller;

import com.hoixuan.be_course_saling_web.model.Notification;
import com.hoixuan.be_course_saling_web.model.dto.NotificationID;
import com.hoixuan.be_course_saling_web.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class NotificationUserAPI {
        @Autowired
        NotificationService notificationService;

        @GetMapping("/notification/{sendTo}")
        public ResponseEntity<List<Notification>> getAll(@PathVariable String sendTo) {
            return new ResponseEntity<>(notificationService.getNewNotificationUser(false,"user",sendTo), HttpStatus.OK);
        }
        @PostMapping("/notification/done")
        public ResponseEntity<Notification> save(@RequestBody List<NotificationID> notifications) {
            for (NotificationID n:notifications) {
                Notification noti = notificationService.findById(n.getIdNotification());
                noti.setStatus(true);
                notificationService.save(noti);
            }
            return new ResponseEntity<>(new Notification(), HttpStatus.OK);
        }
}
