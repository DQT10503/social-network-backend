package com.source_user_authen.repository;

import com.source_user_authen.entity.TblRole;
import com.source_user_authen.utils.enummerate.CommonStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TblRoleRepository extends JpaRepository<TblRole, Long> {
    TblRole findByNameAndStatus(String name, CommonStatus commonStatus);
}