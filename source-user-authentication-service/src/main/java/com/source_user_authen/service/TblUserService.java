package com.source_user_authen.service;

import com.api.framework.domain.DeleteMethodResponse;
import com.api.framework.domain.PagingResponse;
import com.source_user_authen.domain.user.*;
import org.springframework.data.domain.Pageable;

public interface TblUserService {

    PagingResponse search(TblUserRequest request, Pageable pageRequest);

    TblUserResponse insert(TblUserCreateRequest request);

    TblUserResponse update(TblUserUpdateRequest request);

    DeleteMethodResponse delete(Long id);

    TblUserDetailResponse detail(Long id);
}
