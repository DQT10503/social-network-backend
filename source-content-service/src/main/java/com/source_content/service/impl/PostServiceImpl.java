package com.source_content.service.impl;

import com.api.framework.security.BearerContextHolder;
import com.api.framework.service.CommonService;
import com.api.framework.utils.MessageUtil;
import com.api.framework.utils.Utilities;
import com.source_content.domain.TblMediaCreateRequest;
import com.source_content.domain.TblPostCreateRequest;
import com.source_content.domain.TblPostResponse;
import com.source_content.domain.user.UserResponse;
import com.source_content.entity.TblMedia;
import com.source_content.entity.TblPost;
import com.source_content.repository.TblMediaRepository;
import com.source_content.repository.TblPostDraftRepository;
import com.source_content.repository.TblPostRepository;
import com.source_content.service.PostService;
import com.source_content.utils.enummerate.ContentStatus;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import retrofit2.Retrofit;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Transactional
@Service
public class PostServiceImpl implements PostService {
    private final MessageUtil messageUtil;
    private final CommonService commonService;
    private final TblPostRepository postRepository;
    private final TblPostDraftRepository postDraftRepository;
    private final TblMediaRepository mediaRepository;
    @Value("${service-user.base-url}")
    private String baseUrlUser;

    public PostServiceImpl(MessageUtil messageUtil, CommonService commonService, TblPostRepository postRepository, TblPostDraftRepository postDraftRepository, TblMediaRepository mediaRepository) {
        this.messageUtil = messageUtil;
        this.commonService = commonService;
        this.postRepository = postRepository;
        this.postDraftRepository = postDraftRepository;
        this.mediaRepository = mediaRepository;
    }


    @Override
    public TblPostResponse insert(TblPostCreateRequest postRequest, List<TblMediaCreateRequest> mediaRequest) {
        UserResponse user = getUser();
        System.out.println("AAA: " + user.getId());
        TblPost post = Utilities.copyProperties(postRequest, TblPost.class);
        post.setUserId(user.getId());
        post.setStatus(ContentStatus.ACTIVE);
        postRepository.save(post);
        if (ObjectUtils.isEmpty(mediaRequest)) {
            return Utilities.copyProperties(post, TblPostResponse.class);
        }
        mediaRequest.forEach(m -> m.setPostId(post.getId()));
        List<TblMedia> mediaList = Utilities.copyProperties(mediaRequest, TblMedia.class);
        mediaRepository.saveAll(mediaList);
        return Utilities.copyProperties(post, TblPostResponse.class);
    }

    private UserResponse getUser() {
        WebClient webClient = WebClient.builder()
                .baseUrl(baseUrlUser + "/user/search")
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + BearerContextHolder.getContext().getToken())
                .build();
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.queryParam("username", BearerContextHolder.getContext().getMasterAccount()).build())
                .exchangeToMono(response -> response.bodyToMono(UserResponse.class))
                .block();
    }


}
