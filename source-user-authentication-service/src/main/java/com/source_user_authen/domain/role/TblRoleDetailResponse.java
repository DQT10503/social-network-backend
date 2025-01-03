package com.source_user_authen.domain.role;

import com.source_user_authen.utils.enummerate.CommonStatus;

public class TblRoleDetailResponse {
    private Long id;
    private String name;
    private CommonStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        return "TblRoleDetailResponse [id=" + id + ", name=" + name + ", status=" + status + "]";
    }
}
