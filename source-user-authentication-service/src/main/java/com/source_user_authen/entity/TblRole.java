package com.source_user_authen.entity;

import com.source_user_authen.utils.enummerate.CommonStatus;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_role")
public class TblRole extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -3429069368381471937L;
    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CommonStatus status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CommonStatus getStatus() {
        return status;
    }

    public void setStatus(CommonStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TblRole [name=" + name + ", status=" + status + "]";
    }
}