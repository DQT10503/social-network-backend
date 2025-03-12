package com.source_relationship.domain.follower;

import com.source_user_auth.utils.enummerate.CommonStatus;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class TblFollowerUpdateRequest extends TblFollowerCreateRequest {

    @ApiModelProperty(value = "Trạng thái")
    @NotNull
    private CommonStatus status;

    public CommonStatus getStatus() {
        return status;
    }

    public void setStatus(CommonStatus status) {
        this.status = status;
    }

    @Override
    public Long getFollowerId() {
        return super.getFollowerId();
    }

    @Override
    public void setFollowerId(Long followerId) {
        super.setFollowerId(followerId);
    }

    @Override
    public Long getFollowedId() {
        return super.getFollowedId();
    }

    @Override
    public void setFollowedId(Long followedId) {
        super.setFollowedId(followedId);
    }

    @Override
    public String toString() {
        return "TblFollowerUpdateRequest [status=" + status + "]";
    }
}
