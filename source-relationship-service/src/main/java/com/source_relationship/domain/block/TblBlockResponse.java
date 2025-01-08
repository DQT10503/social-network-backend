package com.source_relationship.domain.block;

import com.source_relationship.utils.enumerate.CommonStatus;

public class TblBlockResponse {
    private Long blockerId;
    private Long blockedId;
    private CommonStatus status;

    public Long getBlockerId() {
        return blockerId;
    }

    public void setBlockerId(Long blockerId) {
        this.blockerId = blockerId;
    }

    public Long getBlockedId() {
        return blockedId;
    }

    public void setBlockedId(Long blockedId) {
        this.blockedId = blockedId;
    }

    public CommonStatus getStatus() {
        return status;
    }

    public void setStatus(CommonStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TblBockResponse [blockerId=" + blockerId + ", blockedId=" + blockedId + ", status=" + status + "]";
    }
}
