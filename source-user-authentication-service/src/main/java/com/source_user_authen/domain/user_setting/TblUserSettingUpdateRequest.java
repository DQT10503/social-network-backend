package com.source_user_authen.domain.user_setting;

import com.source_user_authen.utils.enummerate.CommonStatus;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class TblUserSettingUpdateRequest extends TblUserSettingCreateRequest {
    @ApiModelProperty(value = "Id")
    @NotNull
    private Long id;
    @ApiModelProperty(value = "Trạng thái")
    @NotNull
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
    public Boolean getNotification() {
        return super.getNotification();
    }

    @Override
    public void setNotification(Boolean notification) {
        super.setNotification(notification);
    }

    @Override
    public String getPrivacyLevel() {
        return super.getPrivacyLevel();
    }

    @Override
    public void setPrivacyLevel(String privacyLevel) {
        super.setPrivacyLevel(privacyLevel);
    }

    @Override
    public String getTheme() {
        return super.getTheme();
    }

    @Override
    public void setTheme(String theme) {
        super.setTheme(theme);
    }

    @Override
    public String getLanguage() {
        return super.getLanguage();
    }

    @Override
    public void setLanguage(String language) {
        super.setLanguage(language);
    }

    @Override
    public String toString() {
        return "TblUserSettingUpdateRequest [id=" + id + ", status=" + status + "]";
    }
}
