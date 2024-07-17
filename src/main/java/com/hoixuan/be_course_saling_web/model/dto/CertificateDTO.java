package com.hoixuan.be_course_saling_web.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CertificateDTO {
    private String img;
    private long idCourse;
    private Date createAt;
}
