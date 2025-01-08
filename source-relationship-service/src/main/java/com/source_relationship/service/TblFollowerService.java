package com.source_relationship.service;

import com.api.framework.domain.DeleteMethodResponse;
import com.source_relationship.domain.follower.TblFollowerCreateRequest;
import com.source_relationship.domain.follower.TblFollowerResponse;
import com.source_relationship.domain.follower.TblFollowerUpdateRequest;
import com.source_relationship.entity.embedded.TblFollowerId;

public interface TblFollowerService {

    TblFollowerResponse insert(TblFollowerCreateRequest request);

    TblFollowerResponse update(TblFollowerUpdateRequest request);

    DeleteMethodResponse delete(Long followerId, Long followedId);
}
