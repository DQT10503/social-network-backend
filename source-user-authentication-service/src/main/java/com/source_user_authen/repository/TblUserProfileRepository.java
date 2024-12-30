package com.source_user_authen.repository;

import com.source_user_authen.entity.TblUserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TblUserProfileRepository extends JpaRepository<TblUserProfile, Long> {
}