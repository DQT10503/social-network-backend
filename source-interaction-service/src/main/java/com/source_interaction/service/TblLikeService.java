package com.source_interaction.service;

import com.api.framework.domain.PagingResponse;
import com.source_interaction.domain.like.TblLikeCreateRequest;
import com.source_interaction.domain.like.TblLikeRequest;
import com.source_interaction.domain.like.TblLikeResponse;
import org.springframework.data.domain.Pageable;

public interface TblLikeService {
    PagingResponse search(TblLikeRequest request, Pageable pageRequest);
    TblLikeResponse reactPost(Long postId, TblLikeCreateRequest request);
    void removeReaction(Long postId);

}
