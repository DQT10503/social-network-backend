package com.source_user_authen.domain.verification_token;

import java.time.Instant;

public class TblVerificationTokenCreateRequest {
    private Long userId;
    private String accessToken;
    private Instant accessTokenExpired;
    private String refreshToken;
    private Instant refreshTokenExpired;
    private String type;

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

    @Override
    public String toString() {
        return "TblVerificationTokenCreateRequest [userId=" + userId + ", accessToken=" + accessToken + ", accessTokenExpired=" + accessTokenExpired + ", refreshToken=" + refreshToken + ", refreshTokenExpired=" + refreshTokenExpired + ", type=" + type + "]";
    }
}
