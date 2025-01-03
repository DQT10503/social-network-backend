package com.source_user_authen.domain.user_device;

import javax.validation.constraints.NotNull;
import java.time.Instant;

public class TblUserDeviceCreateRequest {
    @NotNull
    private Long userId;
    @NotNull
    private String deviceType;
    private String deviceToken;
    @NotNull
    private Instant lastLogin;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public Instant getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Instant lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return "TblUserCreateRequest [userId=" + userId + ", deviceType=" + deviceType + ", deviceToken=" + deviceToken + ", lastLogin=" + lastLogin + "]";
    }
}
