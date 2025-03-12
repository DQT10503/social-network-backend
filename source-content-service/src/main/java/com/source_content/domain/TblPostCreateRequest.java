package com.source_content.domain;

import com.source_content.utils.enummerate.ContentStatus;
import com.source_content.utils.enummerate.PrivacyLevel;

public class TblPostCreateRequest {
    private Long userId;
    private String content;
    private PrivacyLevel privacyLevel;
    private Object location;
    private ContentStatus status;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PrivacyLevel getPrivacyLevel() {
        return privacyLevel;
    }

    public void setPrivacyLevel(PrivacyLevel privacyLevel) {
        this.privacyLevel = privacyLevel;
    }

    public Object getLocation() {
        return location;
    }

    public void setLocation(Object location) {
        this.location = location;
    }

    public ContentStatus getStatus() {
        return status;
    }

    public void setStatus(ContentStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TblPostCreateRequest [userId=" + userId + ", content=" + content + ", privacyLevel=" + privacyLevel + ", location=" + location + ", status=" + status + "]";
    }
}
