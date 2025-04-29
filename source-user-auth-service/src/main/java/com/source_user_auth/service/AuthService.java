package com.source_user_auth.service;

import com.api.framework.domain.PagingResponse;
import com.source_user_auth.domain.auth.RegisterRequest;
import com.source_user_auth.domain.auth.RegisterResponse;
import com.source_user_auth.domain.user.TblUserResponse;

import java.io.IOException;

public interface AuthService {

    RegisterResponse register(RegisterRequest request) throws IOException;
}
