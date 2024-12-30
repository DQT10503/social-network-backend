package com.source_user_authen.entity;

import com.source_user_authen.utils.enummerate.CommonStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "tbl_user_setting")
public class TblUserSetting extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -5955337530099705541L;
    @Column(name = "notification")
    private Boolean notification;

    @Column(name = "privacy_level")
    private String privacyLevel;

    @Column(name = "theme")
    private String theme;

    @Column(name = "language")
    private String language;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CommonStatus status;

    public Boolean getNotification() {
        return notification;
    }

    public void setNotification(Boolean notification) {
        this.notification = notification;
    }

    public String getPrivacyLevel() {
        return privacyLevel;
    }

    public void setPrivacyLevel(String privacyLevel) {
        this.privacyLevel = privacyLevel;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public CommonStatus getStatus() {
        return status;
    }

    public void setStatus(CommonStatus status) {
        this.status = status;
    }

}