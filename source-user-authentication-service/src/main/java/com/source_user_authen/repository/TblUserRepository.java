package com.source_user_authen.repository;

import com.source_user_authen.entity.TblUser;
import com.source_user_authen.utils.enummerate.CommonStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TblUserRepository extends JpaRepository<TblUser, Long> {
    TblUser findByEmailAndStatus(String email, CommonStatus commonStatus);
}