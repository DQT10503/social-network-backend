package com.source_user_auth.repository;

import com.source_user_auth.entity.TblUserRole;
import com.source_user_auth.entity.embedded.TblUserRoleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TblUserRoleRepository extends JpaRepository<TblUserRole, TblUserRoleId> {
}