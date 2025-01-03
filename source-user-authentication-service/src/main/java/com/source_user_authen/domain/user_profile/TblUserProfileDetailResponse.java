package com.source_user_authen.domain.user_profile;

import com.api.framework.utils.converter.DateTimeJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.source_user_authen.utils.enummerate.CommonStatus;

import java.time.Instant;
import java.util.List;

public class TblUserProfileDetailResponse {
    private Long id;
    @JsonSerialize(using = DateTimeJsonSerializer.class)
    private Instant birthday;
    private String location;
    private Byte gender;
    private String website;
    private String occupation;
    private String education;
    private List<String> interests;
    private CommonStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getBirthday() {
        return birthday;
    }

    public void setBirthday(Instant birthday) {
        this.birthday = birthday;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
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

    public CommonStatus getStatus() {
        return status;
    }

    public void setStatus(CommonStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TblUserProfileDetailResponse [id=" + id + ", birthday=" + birthday + ", location=" + location + ", gender=" + gender + ", website=" + website + ", occupation=" + occupation + ", education=" + education + ", interests=" + interests + ", status=" + status + "]";
    }
}
