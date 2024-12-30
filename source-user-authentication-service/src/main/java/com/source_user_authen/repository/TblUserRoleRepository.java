package com.source_user_authen.repository;

import com.source_user_authen.entity.TblUserRole;
import com.source_user_authen.entity.embedded.TblUserRoleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TblUserRoleRepository extends JpaRepository<TblUserRole, TblUserRoleId> {
}