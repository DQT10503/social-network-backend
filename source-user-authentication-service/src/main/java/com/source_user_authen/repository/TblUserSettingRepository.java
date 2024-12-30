package com.source_user_authen.repository;

import com.source_user_authen.entity.TblUserSetting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TblUserSettingRepository extends JpaRepository<TblUserSetting, Long> {
}