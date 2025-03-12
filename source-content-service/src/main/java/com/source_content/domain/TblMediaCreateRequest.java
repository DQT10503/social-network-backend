package com.source_content.domain;

import com.source_content.utils.enummerate.ContentStatus;

public class TblMediaCreateRequest {
    private Long postId;
    private String url;
    private String type;
    private Object metaData;
    private ContentStatus status;

    public TblMediaCreateRequest(Long postId, String url, String type, Object metaData, ContentStatus status) {
        this.postId = postId;
        this.url = url;
        this.type = type;
        this.metaData = metaData;
        this.status = status;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getMetaData() {
        return metaData;
    }

    public void setMetaData(Object metaData) {
        this.metaData = metaData;
    }

    public ContentStatus getStatus() {
        return status;
    }

    public void setStatus(ContentStatus status) {
        this.status = status;
    }
}
