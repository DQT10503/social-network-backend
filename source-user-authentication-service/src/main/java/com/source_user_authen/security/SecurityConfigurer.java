package com.source_user_authen.security;

import com.source_user_authen.filter.AuthenticationFilter;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class SecurityConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private TokenProvider tokenProvider;

    public SecurityConfigurer(TokenProvider tokenProvider) { this.tokenProvider = tokenProvider; }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        AuthenticationFilter customFilter = new AuthenticationFilter(tokenProvider);

        http.exceptionHandling().authenticationEntryPoint(new AuthenticationEntry()).and().addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
