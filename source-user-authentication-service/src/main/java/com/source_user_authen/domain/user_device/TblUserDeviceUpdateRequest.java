package com.source_user_authen.domain.user_device;

import com.source_user_authen.utils.enummerate.CommonStatus;

import java.time.Instant;

public class TblUserDeviceUpdateRequest extends TblUserDeviceCreateRequest {
    private Long id;
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
    public Long getUserId() {
        return super.getUserId();
    }

    @Override
    public void setUserId(Long userId) {
        super.setUserId(userId);
    }

    @Override
    public String getDeviceType() {
        return super.getDeviceType();
    }

    @Override
    public void setDeviceType(String deviceType) {
        super.setDeviceType(deviceType);
    }

    @Override
    public String getDeviceToken() {
        return super.getDeviceToken();
    }

    @Override
    public void setDeviceToken(String deviceToken) {
        super.setDeviceToken(deviceToken);
    }

    @Override
    public Instant getLastLogin() {
        return super.getLastLogin();
    }

    @Override
    public void setLastLogin(Instant lastLogin) {
        super.setLastLogin(lastLogin);
    }

    @Override
    public String toString() {
        return "TblUserDeviceUpdateRequest [id=" + id + ", status=" + status + "]";
    }
}
