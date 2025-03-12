package com.source_content.service;

import com.source_content.domain.TblMediaCreateRequest;
import com.source_content.domain.TblPostCreateRequest;
import com.source_content.domain.TblPostResponse;

import java.util.List;

public interface PostService {
    TblPostResponse insert(TblPostCreateRequest postRequest, List<TblMediaCreateRequest> mediaRequest);
}
