package com.source_relationship.domain.follower;

import com.source_relationship.utils.enumerate.CommonStatus;

public class TblFollowerResponse {
    private Long followerId;
    private Long followedId;
    private CommonStatus status;

    public Long getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Long followerId) {
        this.followerId = followerId;
    }

    public Long getFollowedId() {
        return followedId;
    }

    public void setFollowedId(Long followedId) {
        this.followedId = followedId;
    }

    public CommonStatus getStatus() {
        return status;
    }

    public void setStatus(CommonStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TblFollowerResponse [followerId=" + followerId + ", followedId=" + followedId + ", status=" + status + "]";
    }
}
