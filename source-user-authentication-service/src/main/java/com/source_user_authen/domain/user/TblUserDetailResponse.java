package com.source_user_authen.domain.user;

import com.source_user_authen.utils.enummerate.CommonStatus;

public class TblUserDetailResponse {
    private String fullName;
    private String email;
    private String userName;
    private String bio;
    private String avatarUrl;
    private CommonStatus status;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public CommonStatus getStatus() {
        return status;
    }

    public void setStatus(CommonStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TblUserDetailResponse [fullName=" + fullName + ", email=" + email + ", userName=" + userName + ", bio=" + bio + ", avatarUrl=" + avatarUrl + ", status=" + status + "]";
    }
}
