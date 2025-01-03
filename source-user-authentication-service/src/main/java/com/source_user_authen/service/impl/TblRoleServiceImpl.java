package com.source_user_authen.service.impl;

import com.api.framework.domain.DeleteMethodResponse;
import com.api.framework.exception.BusinessException;
import com.api.framework.service.CommonService;
import com.api.framework.utils.Constants;
import com.api.framework.utils.MessageUtil;
import com.api.framework.utils.Utilities;
import com.source_user_authen.domain.role.TblRoleCreateRequest;
import com.source_user_authen.domain.role.TblRoleDetailResponse;
import com.source_user_authen.domain.role.TblRoleResponse;
import com.source_user_authen.domain.role.TblRoleUpdateRequest;
import com.source_user_authen.entity.TblRole;
import com.source_user_authen.repository.TblRoleRepository;
import com.source_user_authen.service.TblRoleService;
import com.source_user_authen.utils.MessageCode;
import com.source_user_authen.utils.enummerate.CommonStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Transactional
@Service
public class TblRoleServiceImpl implements TblRoleService {

    private final CommonService commonService;
    private  final MessageUtil messageUtil;
    private final TblRoleRepository roleRepository;

    public TblRoleServiceImpl(CommonService commonService, MessageUtil messageUtil, TblRoleRepository roleRepository) {
        this.commonService = commonService;
        this.messageUtil = messageUtil;
        this.roleRepository = roleRepository;
    }

    @Override
    public TblRoleResponse insert(TblRoleCreateRequest request) {
        TblRole existsRole = roleRepository.findByNameAndStatus(request.getName(), CommonStatus.ACTIVE);
        if (Objects.nonNull(existsRole)) {
            throw new BusinessException(MessageCode.DUPLICATE, messageUtil.getMessage(MessageCode.DUPLICATE), "Name: " + request.getName() + ", Status: " + CommonStatus.ACTIVE);
        }
        TblRole role = Utilities.copyProperties(request, TblRole.class);
        role.setStatus(CommonStatus.ACTIVE);
        roleRepository.save(role);
        return Utilities.copyProperties(role, TblRoleResponse.class);
    }

    @Override
    public TblRoleResponse update(TblRoleUpdateRequest request) {
        TblRole role = getRoleById(request.getId());
        validateUpdate(request, role.getStatus());
        Utilities.updateProperties(request, role);
        roleRepository.save(role);
        return Utilities.copyProperties(role, TblRoleResponse.class);
    }

    @Override
    public DeleteMethodResponse delete(Long id) {
        TblRole role = getRoleById(id);
        if (!CommonStatus.INACTIVE.equals(role.getStatus())) {
            throw new BusinessException(MessageCode.ERR_STATUS, messageUtil.getMessage(MessageCode.ERR_STATUS), "Status: " + role.getStatus());
        }
        roleRepository.delete(role);
        DeleteMethodResponse response = new DeleteMethodResponse();
        response.setId(id);
        return response;
    }

    @Override
    public TblRoleDetailResponse detail(Long id) {
        TblRole role = getRoleById(id);
        return Utilities.copyProperties(role, TblRoleDetailResponse.class);
    }


    private TblRole getRoleById(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new BusinessException(Constants.ERR_404, messageUtil.getMessage(Constants.ERR_404), "Role id: " + id));
    }

    private void validateUpdate(TblRoleUpdateRequest request, CommonStatus status) {
        TblRole existsRole = roleRepository.findByNameAndStatus(request.getName(), CommonStatus.ACTIVE);
        if (Objects.nonNull(existsRole) && !existsRole.getId().equals(request.getId())) {
            throw new BusinessException(MessageCode.DUPLICATE, messageUtil.getMessage(MessageCode.DUPLICATE), "Name: " + request.getName() + ", Status: " + CommonStatus.ACTIVE);
        }
        if (CommonStatus.ACTIVE.equals(request.getStatus()) && CommonStatus.INACTIVE.equals(status)) {
            throw new BusinessException(MessageCode.ERR_STATUS, messageUtil.getMessage(MessageCode.ERR_STATUS), "Status: " + status);
        }
    }
}
