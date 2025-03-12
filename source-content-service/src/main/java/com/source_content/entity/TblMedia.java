package com.source_content.entity;

import com.source_content.utils.enummerate.ContentStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "tbl_media")
public class TblMedia extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Column(name = "post_id", nullable = false)
    private Long postId;

    @Column(name = "url")
    private String url;

    @Column(name = "type")
    private String type;

    @Column(name = "meta_data")
    private Object metaData;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ContentStatus status;

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

    public void setMetadata(Object metaData) {
        this.metaData = metaData;
    }

    public ContentStatus getStatus() {
        return status;
    }

    public void setStatus(ContentStatus status) {
        this.status = status;
    }

}