package com.source_user_authen.service.impl;

import com.api.framework.domain.DeleteMethodResponse;
import com.api.framework.exception.BusinessException;
import com.api.framework.service.CommonService;
import com.api.framework.utils.Constants;
import com.api.framework.utils.MessageUtil;
import com.api.framework.utils.Utilities;
import com.source_user_authen.domain.user_setting.TblUserSettingCreateRequest;
import com.source_user_authen.domain.user_setting.TblUserSettingDetailResponse;
import com.source_user_authen.domain.user_setting.TblUserSettingResponse;
import com.source_user_authen.domain.user_setting.TblUserSettingUpdateRequest;
import com.source_user_authen.entity.TblUserSetting;
import com.source_user_authen.repository.TblUserSettingRepository;
import com.source_user_authen.service.TblUserSettingService;
import com.source_user_authen.utils.MessageCode;
import com.source_user_authen.utils.enummerate.CommonStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TblUserSettingImpl implements TblUserSettingService {

    private final CommonService commonService;
    private final MessageUtil messageUtil;
    private final TblUserSettingRepository userSettingRepository;

    public TblUserSettingImpl(CommonService commonService, MessageUtil messageUtil, TblUserSettingRepository userSettingRepository) {
        this.commonService = commonService;
        this.messageUtil = messageUtil;
        this.userSettingRepository = userSettingRepository;
    }


    @Override
    public TblUserSettingResponse insert(TblUserSettingCreateRequest request) {
        TblUserSetting userSetting = Utilities.copyProperties(request, TblUserSetting.class);
        userSetting.setStatus(CommonStatus.ACTIVE);
        return Utilities.copyProperties(userSetting, TblUserSettingResponse.class);
    }

    @Override
    public TblUserSettingResponse update(TblUserSettingUpdateRequest request) {
        TblUserSetting userSetting = getUserSettingById(request.getId());
        Utilities.updateProperties(request, TblUserSetting.class);
        userSettingRepository.save(userSetting);
        return Utilities.copyProperties(userSetting, TblUserSettingResponse.class);
    }

    @Override
    public DeleteMethodResponse delete(Long id) {
        TblUserSetting userSetting = getUserSettingById(id);
        if (!CommonStatus.INACTIVE.equals(userSetting.getStatus())) {
            throw new BusinessException(MessageCode.ERR_STATUS, messageUtil.getMessage(MessageCode.ERR_STATUS), "Status: " + userSetting.getStatus());
        }
        userSettingRepository.delete(userSetting);
        DeleteMethodResponse response = new DeleteMethodResponse();
        response.setId(id);
        return response;
    }

    @Override
    public TblUserSettingDetailResponse detail(Long id) {
        TblUserSetting userSetting = getUserSettingById(id);
        return Utilities.copyProperties(userSetting, TblUserSettingDetailResponse.class);
    }

    private TblUserSetting getUserSettingById(Long id) {
        return userSettingRepository.findById(id).orElseThrow(() -> new BusinessException(Constants.ERR_404, messageUtil.getMessage(Constants.ERR_404), "Id: " + id));
    }
}
