package com.source_user_authen.domain.user_setting;

import com.source_user_authen.utils.enummerate.CommonStatus;

public class TblUserSettingResponse {
    private Long id;
    private Boolean notification;
    private String privacyLevel;
    private String theme;
    private String language;
    private CommonStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "TblUserSettingResponse [id=" + id + ", notification=" + notification + ", privacyLevel=" + privacyLevel + ", theme=" + theme + ", language=" + language + ", status=" + status + "]";
    }
}
