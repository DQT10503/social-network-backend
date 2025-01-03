package com.source_user_authen.domain.user_setting;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TblUserSettingCreateRequest {
    @ApiModelProperty(value = "Thông báo")
    private Boolean notification;
    @ApiModelProperty(value = "Quyền riêng tư")
    private String privacyLevel;
    @ApiModelProperty(value = "Chủ đề")
    private String theme;
    @ApiModelProperty(value = "Ngôn ngữ")
    private String language;

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

    @Override
    public String toString() {
        return "TblUserSettingCreateRequest [notification=" + notification + ", privacyLevel=" + privacyLevel + ", theme=" + theme + ", language=" + language + "]";
    }
}
