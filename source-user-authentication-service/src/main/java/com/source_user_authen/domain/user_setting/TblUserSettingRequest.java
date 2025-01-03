package com.source_user_authen.domain.user_setting;

import com.api.framework.utils.Annotations;
import com.source_user_authen.utils.enummerate.CommonStatus;

public class TblUserSettingRequest {
    private Boolean notification;
    private String privacyLevel;
    @Annotations.Operator(value = "LIKE")
    private String theme;
    @Annotations.Operator(value = "LIKE")
    private String language;
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

    @Override
    public String toString() {
        return "TblUserSettingRequest [notification=" + notification + ", privacyLevel=" + privacyLevel + ", theme=" + theme + ", language=" + language + ", status=" + status + "]";
    }
}
