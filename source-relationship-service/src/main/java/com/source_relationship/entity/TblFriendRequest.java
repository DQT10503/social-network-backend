package com.source_relationship.entity;

import com.source_relationship.entity.embedded.TblFriendRequestId;
import com.source_relationship.utils.enumerate.CommonStatus;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_friend_request")
public class TblFriendRequest extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -7717171079817391148L;
    @EmbeddedId
    private TblFriendRequestId id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private CommonStatus status;

    public TblFriendRequestId getId() {
        return id;
    }

    public void setId(TblFriendRequestId id) {
        this.id = id;
    }

    public CommonStatus getStatus() {
        return status;
    }

    public void setStatus(CommonStatus status) {
        this.status = status;
    }

}