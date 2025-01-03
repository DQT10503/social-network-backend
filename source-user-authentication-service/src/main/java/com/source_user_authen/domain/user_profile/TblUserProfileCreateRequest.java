package com.source_user_authen.domain.user_profile;

import io.swagger.annotations.ApiModelProperty;

import java.time.Instant;
import java.util.List;

public class TblUserProfileCreateRequest {
    @ApiModelProperty(value = "Số điện thoại")
    private String phone;
    @ApiModelProperty(value = "Sinh nhật")
    private Instant birthday;
    @ApiModelProperty(value = "Giới tính")
    private Byte gender;
    @ApiModelProperty(value = "Địa chỉ")
    private String location;
    @ApiModelProperty(value = "Trang web")
    private String website;
    @ApiModelProperty(value = "Nghề nghiệp")
    private String occupation;
    @ApiModelProperty(value = "Học vấn")
    private String education;
    @ApiModelProperty(value = "Sở thích")
    private List<String> interests;

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

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    @Override
    public String toString() {
        return "TblUserProfileCreateRequest [phone=" + phone + ", birthday=" + birthday + ", gender=" + gender + ", location=" + location + ", website=" + website + ", occupation=" + occupation + ", education=" + education + ", interests=" + interests + "]";
    }
}
