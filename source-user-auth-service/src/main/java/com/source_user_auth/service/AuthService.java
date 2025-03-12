package com.source_user_auth.service;

import com.api.framework.domain.PagingResponse;
import com.source_user_auth.domain.auth.RegisterRequest;
import com.source_user_auth.domain.auth.RegisterResponse;
import com.source_user_auth.domain.user.TblUserResponse;

public interface AuthService {

    RegisterResponse register(RegisterRequest request);
}
