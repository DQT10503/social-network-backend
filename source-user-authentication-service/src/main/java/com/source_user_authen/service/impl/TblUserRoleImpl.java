package com.source_user_authen.service.impl;

import com.api.framework.domain.DeleteMethodResponse;
import com.api.framework.exception.BusinessException;
import com.api.framework.service.CommonService;
import com.api.framework.utils.MessageUtil;
import com.api.framework.utils.Utilities;
import com.source_user_authen.domain.user_role.TblUserRoleCreateRequest;
import com.source_user_authen.domain.user_role.TblUserRoleResponse;
import com.source_user_authen.domain.user_role.TblUserRoleUpdateRequest;
import com.source_user_authen.entity.TblUserRole;
import com.source_user_authen.entity.embedded.TblUserRoleId;
import com.source_user_authen.repository.TblUserRoleRepository;
import com.source_user_authen.service.TblUserRoleService;
import com.source_user_authen.utils.MessageCode;
import com.source_user_authen.utils.enummerate.CommonStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TblUserRoleImpl implements TblUserRoleService {

    private final CommonService commonService;
    private final MessageUtil messageUtil;
    private final TblUserRoleRepository userRoleRepository;

    public TblUserRoleImpl(CommonService commonService, MessageUtil messageUtil, TblUserRoleRepository userRoleRepository) {
        this.commonService = commonService;
        this.messageUtil = messageUtil;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public TblUserRoleResponse insert(TblUserRoleCreateRequest request) {
        TblUserRole userRole = Utilities.copyProperties(request, TblUserRole.class);
        userRole.setStatus(CommonStatus.ACTIVE);
        userRoleRepository.save(userRole);
        return Utilities.copyProperties(userRole, TblUserRoleResponse.class);
    }

    @Override
    public TblUserRoleResponse update(TblUserRoleUpdateRequest request) {
        TblUserRole userRole = getUserRoleById(request.getUserId(), request.getRoleId());
        if (CommonStatus.ACTIVE.equals(request.getStatus()) && CommonStatus.INACTIVE.equals(userRole.getStatus())) {
            throw new BusinessException(MessageCode.ERR_STATUS, messageUtil.getMessage(MessageCode.ERR_STATUS), "Status: " + request.getStatus());
        }
        Utilities.updateProperties(request, userRole);
        return Utilities.copyProperties(userRole, TblUserRoleResponse.class);
    }

    @Override
    public DeleteMethodResponse delete(Long userId, Long roleId) {
        TblUserRole userRole = getUserRoleById(userId, roleId);
        if (!CommonStatus.INACTIVE.equals(userRole.getStatus())) {
            throw new BusinessException(MessageCode.ERR_STATUS, messageUtil.getMessage(MessageCode.ERR_STATUS), "Status: " + userRole.getStatus());
        }
        userRoleRepository.delete(userRole);
        DeleteMethodResponse response = new DeleteMethodResponse();
        response.setId(userId);
        response.setRoleId(roleId);
        return response;
    }

    private TblUserRole getUserRoleById(Long userId, Long roleId) {
        TblUserRoleId id = new TblUserRoleId();
        id.setUserId(userId);
        id.setRoleId(roleId);
        return userRoleRepository.findById(id).orElseThrow(() -> new BusinessException(MessageCode.ERR_STATUS, messageUtil.getMessage(MessageCode.ERR_STATUS), "User id: " + userId + ", Role id: " + roleId));
    }
}
