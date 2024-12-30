package com.source_user_authen.entity;

import com.source_user_authen.utils.enummerate.CommonStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tbl_verification_token")
public class TblVerificationToken extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -5277054238801597951L;
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "access_token")
    private String accessToken;

    @Column(name = "access_token_expired")
    private Instant accessTokenExpired;

    @Column(name = "refresh_token")
    private String refreshToken;

    @Column(name = "refresh_token_expired")
    private Instant refreshTokenExpired;

    @Column(name = "type", length = 50)
    private String type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CommonStatus status;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Instant getAccessTokenExpired() {
        return accessTokenExpired;
    }

    public void setAccessTokenExpired(Instant accessTokenExpired) {
        this.accessTokenExpired = accessTokenExpired;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Instant getRefreshTokenExpired() {
        return refreshTokenExpired;
    }

    public void setRefreshTokenExpired(Instant refreshTokenExpired) {
        this.refreshTokenExpired = refreshTokenExpired;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CommonStatus getStatus() {
        return status;
    }

    public void setStatus(CommonStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TblVerificationToken [userId=" + userId + ", accessToken=" + accessToken + ", accessTokenExpired=" + accessTokenExpired + ", refreshToken=" + refreshToken + ", refreshTokenExpired=" + refreshTokenExpired + ", type=" + type + ", status=" + status + "]";
    }
}