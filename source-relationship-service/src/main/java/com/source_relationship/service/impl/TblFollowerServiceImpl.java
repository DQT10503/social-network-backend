package com.source_relationship.service.impl;

import com.api.framework.domain.DeleteMethodResponse;
import com.api.framework.exception.BusinessException;
import com.api.framework.service.CommonService;
import com.api.framework.utils.Constants;
import com.api.framework.utils.MessageUtil;
import com.api.framework.utils.Utilities;
import com.source_relationship.domain.follower.TblFollowerCreateRequest;
import com.source_relationship.domain.follower.TblFollowerResponse;
import com.source_relationship.domain.follower.TblFollowerUpdateRequest;
import com.source_relationship.entity.TblFollower;
import com.source_relationship.entity.embedded.TblFollowerId;
import com.source_relationship.repository.TblFollowerRepository;
import com.source_relationship.service.TblFollowerService;
import com.source_relationship.utils.enumerate.CommonStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TblFollowerServiceImpl implements TblFollowerService {

    private TblFollowerRepository followerRepository;
    private CommonService commonService;
    private MessageUtil messageUtil;

    @Override
    public TblFollowerResponse insert(TblFollowerCreateRequest request) {
        TblFollower follower = Utilities.copyProperties(request, TblFollower.class);
        follower.setStatus(CommonStatus.ACTIVE);
        followerRepository.save(follower);
        return Utilities.copyProperties(follower, TblFollowerResponse.class);
    }

    @Override
    public TblFollowerResponse update(TblFollowerUpdateRequest request) {
        TblFollower follower = getFollowerById(request.getFollowerId(), request.getFollowedId());
        Utilities.updateProperties(request, follower);
        return Utilities.copyProperties(follower, TblFollowerResponse.class);
    }

    @Override
    public DeleteMethodResponse delete(Long followerId, Long followedId) {
        TblFollower follower = getFollowerById(followedId, followedId);
        followerRepository.delete(follower);
        DeleteMethodResponse response = new DeleteMethodResponse();
        response.setId(followerId);
        return response;
    }

    private TblFollower getFollowerById(Long followerId, Long followedId) {
        TblFollowerId id = new TblFollowerId(followerId, followedId);
        return followerRepository.findById(id).orElseThrow(() -> new BusinessException(Constants.ERR_404, messageUtil.getMessage(Constants.ERR_404), "FollowerId: " + followerId + ", FollowedId: " + followedId));
    }
}
