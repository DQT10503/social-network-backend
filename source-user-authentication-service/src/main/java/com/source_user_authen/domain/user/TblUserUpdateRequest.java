package com.source_user_authen.domain.user;

import com.source_user_authen.utils.enummerate.CommonStatus;
import io.swagger.annotations.ApiModelProperty;

public class TblUserUpdateRequest extends TblUserCreateRequest {
    @ApiModelProperty(value = "User id")
    private Long id;
    @ApiModelProperty(value = "Tên tài khoản")
    private String userName;
    @ApiModelProperty(value = "Tiểu sử")
    private String bio;
    @ApiModelProperty(value = "Url ảnh đại diện")
    private String avatarUrl;
    @ApiModelProperty(value = "Trạng thái")
    private CommonStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public String getFullName() {
        return super.getFullName();
    }

    @Override
    public void setFullName(String fullName) {
        super.setFullName(fullName);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public String getPasswordHash() {
        return super.getPasswordHash();
    }

    @Override
    public void setPasswordHash(String passwordHash) {
        super.setPasswordHash(passwordHash);
    }

    @Override
    public String toString() {
        return "TblUserUpdateRequest [id=" + id + ", fullName: " + getFullName() + ", email: " + getEmail() + ", userName: " + userName + ", bio=" + bio + ", avatarUrl=" + avatarUrl + ", status=" + status + "]";
    }
}
