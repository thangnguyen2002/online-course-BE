package com.hoixuan.be_course_saling_web.model.dto;

import java.sql.Date;

public class ChangeProfileUser {
    private String avartar;
    private String fullName;
    private String userName;
    private String address;
    private Date dateOfBirth;
    private String phone;
    private String description;
    private String email;

    public ChangeProfileUser(String avartar, String fullName, String userName, String address, Date dateOfBirth, String phone, String description, String email) {
        this.avartar = avartar;
        this.fullName = fullName;
        this.userName = userName;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.description = description;
        this.email = email;
    }

    public String getAvartar() {
        return avartar;
    }

    public void setAvartar(String avartar) {
        this.avartar = avartar;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
