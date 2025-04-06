package com.source_interaction.service.impl;

import com.api.framework.domain.PagingResponse;
import com.api.framework.exception.BusinessException;
import com.api.framework.security.BearerContextHolder;
import com.api.framework.utils.Constants;
import com.api.framework.utils.MessageUtil;
import com.api.framework.utils.Utilities;
import com.source_interaction.domain.post.PostResponse;
import com.source_interaction.domain.react.TblLikeCreateRequest;
import com.source_interaction.domain.user.UserResponse;
import com.source_interaction.entity.TblLike;
import com.source_interaction.entity.embedded.TblLikeId;
import com.source_interaction.repository.*;
import com.source_interaction.service.InteractionService;
import com.source_interaction.service.retrofit.PostApiService;
import com.source_interaction.service.retrofit.UserApiService;
import com.source_interaction.utils.enummerate.ReactionType;
import retrofit2.Call;
import retrofit2.Response;

import java.util.List;

public class InteractionServiceImpl implements InteractionService {

    private final TblLikeRepository likeRepository;
    private final TblCommentLikeRepository commentLikeRepository;
    private final TblCommentRepository commentRepository;
    private final TblSavedPostRepository savedPostRepository;
    private final TblShareRepository shareRepository;
    private final PostApiService postApiService;
    private final UserApiService userApiService;
    private final MessageUtil messageUtil;

    public InteractionServiceImpl(TblLikeRepository likeRepository, TblCommentLikeRepository commentLikeRepository, TblCommentRepository commentRepository, TblSavedPostRepository savedPostRepository, TblShareRepository shareRepository, PostApiService postApiService, UserApiService userApiService, MessageUtil messageUtil) {
        this.likeRepository = likeRepository;
        this.commentLikeRepository = commentLikeRepository;
        this.commentRepository = commentRepository;
        this.savedPostRepository = savedPostRepository;
        this.shareRepository = shareRepository;
        this.postApiService = postApiService;
        this.userApiService = userApiService;
        this.messageUtil = messageUtil;
    }

    @Override
    public void reactPost(Long postId, TblLikeCreateRequest request) {
        PostResponse post = getPost(postId);
        UserResponse user = getUser();
        TblLike like = new TblLike();
        like.setId(new TblLikeId(user.getId(), post.getId()));
        like.setStatus(request.getReactionType());
        likeRepository.save(like);
    }

    @Override
    public void reactComment(Long commentId, ReactionType reaction) {

    }

    @Override
    public void removeReaction(Long postId) {

    }

    @Override
    public void commentPost(Long postId, String content) {

    }

    @Override
    public void deleteComment(Long commentId) {

    }

    private PostResponse getPost(Long postId) {
        try {
            Call<PagingResponse> call = postApiService.getPost("Bearer " + BearerContextHolder.getContext().getToken(), postId);
            Response<PagingResponse> response = call.execute();
            if (!response.isSuccessful()) {
                throw new RuntimeException("Post API call failed: " + response.code() + " - " + response.message());
            }
            List<PagingResponse> pagingRs = (List<PagingResponse>) response.body().getData();
            List<PostResponse> posts = Utilities.copyProperties(pagingRs, PostResponse.class);
            return posts.get(0);
        } catch (Exception e) {
            throw new BusinessException(Constants.ERR_404, messageUtil.getMessage(Constants.ERR_404), "Post ID: " + postId);
        }
    }

    private UserResponse getUser() {
        try {
            Call<PagingResponse> call = userApiService.getUser("Bearer " + BearerContextHolder.getContext().getToken(), BearerContextHolder.getContext().getMasterAccount());
            Response<PagingResponse> response = call.execute();
            if(!response.isSuccessful()) {
                throw new RuntimeException("User API call failed: " + response.code() + " - " + response.message());
            }
            List<PagingResponse> pagingRs = (List<PagingResponse>) response.body().getData();
            List<UserResponse> users = Utilities.copyProperties(pagingRs, UserResponse.class);
            return users.get(0);
        } catch (Exception e) {
            throw new BusinessException(Constants.ERR_404, messageUtil.getMessage(Constants.ERR_404), "Username: " + BearerContextHolder.getContext().getMasterAccount());
        }
    }
}
