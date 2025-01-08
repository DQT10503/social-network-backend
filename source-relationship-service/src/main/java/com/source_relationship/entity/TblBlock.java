package com.source_relationship.entity;

import com.source_relationship.entity.embedded.TblBlockId;
import com.source_relationship.utils.enumerate.CommonStatus;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_block")
public class TblBlock extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -5605683527518350367L;
    @EmbeddedId
    private TblBlockId id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private CommonStatus status;

    public TblBlockId getId() {
        return id;
    }

    public void setId(TblBlockId id) {
        this.id = id;
    }

    public CommonStatus getStatus() {
        return status;
    }

    public void setStatus(CommonStatus status) {
        this.status = status;
    }

}