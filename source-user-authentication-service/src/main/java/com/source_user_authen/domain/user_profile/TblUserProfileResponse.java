package com.source_user_authen.domain.user_profile;

import com.api.framework.utils.converter.DateTimeJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.source_user_authen.utils.enummerate.CommonStatus;

import java.time.Instant;
import java.util.List;

public class TblUserProfileResponse {
    private Long id;
    private String phone;
    @JsonSerialize(using = DateTimeJsonSerializer.class)
    private Instant birthday;
    private Short gender;
    private String location;
    private String website;
    private String occupation;
    private List<String> interests;
    private CommonStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public CommonStatus getStatus() {
        return status;
    }

    public void setStatus(CommonStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TblUserProfileResponse [id=" + id + ", phone=" + phone + ", birthday=" + birthday + ", gender=" + gender + ", location=" + location + ", website=" + website + ", occupation=" + occupation + ", interests=" + interests + ", status=" + status + "]";
    }
}
