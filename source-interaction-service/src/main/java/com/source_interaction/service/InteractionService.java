package com.source_interaction.service;

import com.source_interaction.domain.react.TblLikeCreateRequest;
import com.source_interaction.utils.enummerate.ReactionType;

public interface InteractionService {
    void reactPost(Long postId, TblLikeCreateRequest request);
    void reactComment(Long commentId, ReactionType reaction);
    void removeReaction(Long postId);
    void commentPost(Long postId, String content);
    void deleteComment(Long commentId);
}
