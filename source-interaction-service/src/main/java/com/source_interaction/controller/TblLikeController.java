package com.source_interaction.controller;

import com.api.framework.security.BearerContextHolder;
import com.source_interaction.domain.like.TblLikeCreateRequest;
import com.source_interaction.domain.like.TblLikeResponse;
import com.source_interaction.service.TblLikeService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(description = "Module tương tác bài viết")
@RestController
@RequestMapping("/interaction/like")
public class TblLikeController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final TblLikeService likeService;

    public TblLikeController(TblLikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/{postId}")
    ResponseEntity<TblLikeResponse> insert(@RequestBody TblLikeCreateRequest request,
                                           @PathVariable("postId") Long postId) {
        String masterAccount = BearerContextHolder.getContext().getMasterAccount();
        logger.info("{} Insert {}", masterAccount, request);
        return ResponseEntity.ok(likeService.reactPost(postId, request));
    }
}
