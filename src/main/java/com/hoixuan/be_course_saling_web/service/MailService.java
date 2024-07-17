package com.hoixuan.be_course_saling_web.service;


import com.hoixuan.be_course_saling_web.model.dto.DataMailDTO;

import javax.mail.MessagingException;

public interface MailService {
    void sendHtmlMail(DataMailDTO dataMail, String templateName) throws MessagingException;
}
