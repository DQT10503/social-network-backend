package com.source_user_authen.service;

import com.api.framework.domain.DeleteMethodResponse;
import com.source_user_authen.domain.user_setting.TblUserSettingCreateRequest;
import com.source_user_authen.domain.user_setting.TblUserSettingDetailResponse;
import com.source_user_authen.domain.user_setting.TblUserSettingResponse;
import com.source_user_authen.domain.user_setting.TblUserSettingUpdateRequest;

public interface TblUserSettingService {

    TblUserSettingResponse insert(TblUserSettingCreateRequest request);

    TblUserSettingResponse update(TblUserSettingUpdateRequest request);

    DeleteMethodResponse delete(Long id);

    TblUserSettingDetailResponse detail(Long id);
}
