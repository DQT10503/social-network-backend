package com.source_relationship.domain.friend_request;

import com.source_relationship.utils.enumerate.CommonStatus;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class TblFriendRequestUpdateRequest extends TblFriendRequestCreateRequest {

    @ApiModelProperty(value = "Trạng thái")
    @NotNull
    CommonStatus status;

    public CommonStatus getStatus() {
        return status;
    }

    public void setStatus(CommonStatus status) {
        this.status = status;
    }

    @Override
    public Long getSenderId() {
        return super.getSenderId();
    }

    @Override
    public void setSenderId(Long senderId) {
        super.setSenderId(senderId);
    }

    @Override
    public Long getReceiverId() {
        return super.getReceiverId();
    }

    @Override
    public void setReceiverId(Long receiverId) {
        super.setReceiverId(receiverId);
    }

    @Override
    public String toString() {
        return "TblFriendRequestUpdateRequest [status=" + status + "]";
    }
}
