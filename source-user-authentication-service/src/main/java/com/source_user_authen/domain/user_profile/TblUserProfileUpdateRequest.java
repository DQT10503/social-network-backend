package com.source_user_authen.domain.user_profile;

import com.source_user_authen.utils.enummerate.CommonStatus;
import io.swagger.annotations.ApiModelProperty;

import java.time.Instant;
import java.util.List;

public class TblUserProfileUpdateRequest extends TblUserProfileCreateRequest {
    @ApiModelProperty(value = "ID")
    private Long id;
    @ApiModelProperty(value = "Trạng thái")
    private CommonStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CommonStatus getStatus() {
        return status;
    }

    public void setStatus(CommonStatus status) {
        this.status = status;
    }

    @Override
    public String getPhone() {
        return super.getPhone();
    }

    @Override
    public void setPhone(String phone) {
        super.setPhone(phone);
    }

    @Override
    public Instant getBirthday() {
        return super.getBirthday();
    }

    @Override
    public void setBirthday(Instant birthday) {
        super.setBirthday(birthday);
    }

    @Override
    public Byte getGender() {
        return super.getGender();
    }

    @Override
    public void setGender(Byte gender) {
        super.setGender(gender);
    }

    @Override
    public String getLocation() {
        return super.getLocation();
    }

    @Override
    public void setLocation(String location) {
        super.setLocation(location);
    }

    @Override
    public String getWebsite() {
        return super.getWebsite();
    }

    @Override
    public void setWebsite(String website) {
        super.setWebsite(website);
    }

    @Override
    public String getOccupation() {
        return super.getOccupation();
    }

    @Override
    public void setOccupation(String occupation) {
        super.setOccupation(occupation);
    }

    @Override
    public String getEducation() {
        return super.getEducation();
    }

    @Override
    public void setEducation(String education) {
        super.setEducation(education);
    }

    @Override
    public List<String> getInterests() {
        return super.getInterests();
    }

    @Override
    public void setInterests(List<String> interests) {
        super.setInterests(interests);
    }

    @Override
    public String toString() {
        return "TblUserProfileUpdateRequest [id=" + id + ", status=" + status + "]";
    }
}
