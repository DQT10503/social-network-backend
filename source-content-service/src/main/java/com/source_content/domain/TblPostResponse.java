package com.source_content.domain;

import com.source_content.utils.enummerate.ContentStatus;
import com.source_content.utils.enummerate.PrivacyLevel;

public class TblPostResponse {
    private Long postId;
    private String content;
    private PrivacyLevel privacyLevel;
    private ContentStatus status;

    public TblPostResponse(Long postId, String content, PrivacyLevel privacyLevel, ContentStatus status) {
        this.postId = postId;
        this.content = content;
        this.privacyLevel = privacyLevel;
        this.status = status;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
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

    public ContentStatus getStatus() {
        return status;
    }

    public void setStatus(ContentStatus status) {
        this.status = status;
    }
}
