package com.source_user_authen.domain.user_profile;

import io.swagger.annotations.ApiModelProperty;

import java.time.Instant;

public class TblUserProfileRequest {
    @ApiModelProperty(value = "Số điện thoại")
    private String phone;
    @ApiModelProperty(value = "Sinh nhật")
    private Instant birthday;
    @ApiModelProperty(value = "Giới tính")
    private Short gender;
    @ApiModelProperty(value = "Địa chỉ")
    private String location;
    @ApiModelProperty(value = "Học vấn")
    private String education;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Instant getBirthday() {
        return birthday;
    }

    public void setBirthday(Instant birthday) {
        this.birthday = birthday;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "TblUserProfileRequest [phone=" + phone + ", birthday=" + birthday + ", gender=" + gender + ", location=" + location + ", education=" + education + "]";
    }
}
