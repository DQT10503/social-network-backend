package com.source_content.controller;

import com.api.framework.security.BearerContextHolder;
import com.source_content.domain.TblMediaCreateRequest;
import com.source_content.domain.TblPostCreateRequest;
import com.source_content.domain.TblPostResponse;
import com.source_content.service.PostService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Api(description = "Module Post")
@RestController
@RequestMapping("/post")
public class PostController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<TblPostResponse> create(@Valid @RequestBody TblPostCreateRequest postRequest,
                                                  @Valid @RequestBody List<TblMediaCreateRequest> mediaRequest) {
        String masterAccount = BearerContextHolder.getContext().getMasterAccount();
        logger.info("{} Create post {} {}", masterAccount, postRequest, mediaRequest);
        return ResponseEntity.ok(postService.insert(postRequest, mediaRequest));
    }
}
