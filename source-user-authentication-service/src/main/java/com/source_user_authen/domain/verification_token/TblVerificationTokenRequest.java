package com.source_user_authen.domain.verification_token;

import com.source_user_authen.utils.enummerate.CommonStatus;

import java.time.Instant;

public class TblVerificationTokenRequest {
    private Long userId;
    private String accessToken;
    private Instant refreshTokenExpired;
    private String type;
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
        return "TblVerificationTokenRequest [userId=" + userId + ", accessToken=" + accessToken + ", refreshTokenExpired=" + refreshTokenExpired + ", type=" + type + ", status=" + status + "]";
    }
}
