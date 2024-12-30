package com.source_user_authen.entity;

import com.source_user_authen.utils.enummerate.CommonStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tbl_user_device")
public class TblUserDevice extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -7865337723924352942L;
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "device_token")
    private String deviceToken;

    @Column(name = "device_type")
    private String deviceType;

    @Column(name = "last_login")
    private Instant lastLogin;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CommonStatus status;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public Instant getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Instant lastLogin) {
        this.lastLogin = lastLogin;
    }

    public CommonStatus getStatus() {
        return status;
    }

    public void setStatus(CommonStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TblUserDevice [userId=" + userId + ", deviceToken=" + deviceToken + ", deviceType=" + deviceType + ", lastLogin=" + lastLogin + ", status=" + status + "]";
    }
}