package com.source_content.service;

import com.api.framework.domain.PagingResponse;
import com.source_content.domain.user.UserResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface CallApiService {
    @GET("user/search")
    Call<PagingResponse> getUser(@Header("Authorization") String token, @Query("username") String username);
}
