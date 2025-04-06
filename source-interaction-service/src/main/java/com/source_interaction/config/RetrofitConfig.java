package com.source_interaction.config;

import com.source_interaction.service.retrofit.PostApiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
public class RetrofitConfig {
    @Value("${post-service.base-url}")
    private String baseUrlPost;

    @Bean
    public PostApiService configPostApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrlPost)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        PostApiService postApiService = retrofit.create(PostApiService.class);
        return postApiService;
    }

    @Bean
    public Us
}
