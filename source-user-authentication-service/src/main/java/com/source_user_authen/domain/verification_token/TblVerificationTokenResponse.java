package com.source_user_authen.domain.verification_token;

import com.source_user_authen.utils.enummerate.CommonStatus;

import java.time.Instant;

public class TblVerificationTokenResponse {
    private Long id;
    private Long userId;
    private String accessToken;
    private Instant accessTokenExpired;
    private String refreshToken;
    private Instant refreshTokenExpired;
    private String type;
    private CommonStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        return "TblVerificationTokenResponse [id=" + id + ", userId=" + userId + ", accessToken=" + accessToken + ", accessTokenExpired=" + accessTokenExpired + ", refreshToken=" + refreshToken + ", refreshTokenExpired=" + refreshTokenExpired + ", type=" + type + ", status=" + status + "]";
    }
}
