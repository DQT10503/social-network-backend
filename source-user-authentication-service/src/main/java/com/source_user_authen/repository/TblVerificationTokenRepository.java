package com.source_user_authen.repository;

import com.source_user_authen.entity.TblVerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TblVerificationTokenRepository extends JpaRepository<TblVerificationToken, Long> {
}