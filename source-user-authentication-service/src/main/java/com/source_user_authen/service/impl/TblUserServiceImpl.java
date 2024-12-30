package com.source_user_authen.service.impl;

import com.api.framework.domain.DeleteMethodResponse;
import com.api.framework.domain.PagingResponse;
import com.api.framework.exception.BusinessException;
import com.api.framework.service.CommonService;
import com.api.framework.utils.Constants;
import com.api.framework.utils.MessageUtil;
import com.api.framework.utils.SimpleQueryBuilder;
import com.api.framework.utils.Utilities;
import com.source_user_authen.domain.user.*;
import com.source_user_authen.entity.TblUser;
import com.source_user_authen.repository.TblUserRepository;
import com.source_user_authen.service.TblUserService;
import com.source_user_authen.utils.MessageCode;
import com.source_user_authen.utils.enummerate.CommonStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@Transactional
public class TblUserServiceImpl implements TblUserService {
    private final TblUserRepository userRepository;
    private final MessageUtil messageUtil;
    private final CommonService commonService;

    public TblUserServiceImpl(TblUserRepository userRepository, MessageUtil messageUtil, CommonService commonService) {
        this.userRepository = userRepository;
        this.messageUtil = messageUtil;
        this.commonService = commonService;
    }

    @SuppressWarnings("unchecked")
    @Override
    public PagingResponse search(TblUserRequest request, Pageable pageRequest) {
        StringBuilder whereClause = new StringBuilder("1 = 1");
        SimpleQueryBuilder simpleQueryBuilder = new SimpleQueryBuilder();
        Map<String, Object> params = new HashMap<>();
        whereClause.append(Utilities.buildWhereClause(request, params));

        simpleQueryBuilder.where(whereClause.toString());
        simpleQueryBuilder.from("tbl_user");

        PagingResponse pagingRs = commonService.executeSearchData(pageRequest, simpleQueryBuilder, params, TblUser.class);
        List<TblUser> datas = (List<TblUser>) pagingRs.getData();
        List<TblUserResponse> caseResponses = Utilities.copyProperties(datas, TblUserResponse.class);
        pagingRs.setData(caseResponses);
        return pagingRs;
    }

    @Override
    public TblUserResponse insert(TblUserCreateRequest request) {
        TblUser existsUser = userRepository.findByEmailAndStatus(request.getEmail(), CommonStatus.ACTIVE);
        if (Objects.nonNull(existsUser)) {
            throw new BusinessException(MessageCode.ERR_01003, messageUtil.getMessage(MessageCode.ERR_01003), "Email: " + request.getEmail() + ", Status: " + CommonStatus.ACTIVE);
        }
        TblUser user = Utilities.copyProperties(request, TblUser.class);
        user.setStatus(CommonStatus.ACTIVE);
        userRepository.save(user);
        return Utilities.copyProperties(user, TblUserResponse.class);
    }

    @Override
    public TblUserResponse update(TblUserUpdateRequest request) {
        TblUser user = getUserById(request.getId());
        validateUpdate(request, user.getStatus());
        Utilities.updateProperties(request, user);
        userRepository.save(user);
        return Utilities.copyProperties(user, TblUserResponse.class);
    }

    @Override
    public DeleteMethodResponse delete(Long id) {
        TblUser user = getUserById(id);
        if (!CommonStatus.INACTIVE.equals(user.getStatus())) {
            throw new BusinessException(MessageCode.ERR_01004, messageUtil.getMessage(MessageCode.ERR_01004), "Status: " + user.getStatus());
        }
        userRepository.delete(user);
        DeleteMethodResponse response = new DeleteMethodResponse();
        response.setId(id);
        return response;
    }

    @Override
    public TblUserDetailResponse detail(Long id) {
        TblUser user = getUserById(id);
        return Utilities.copyProperties(user, TblUserDetailResponse.class);
    }

    private TblUser getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new BusinessException(Constants.ERR_404, messageUtil.getMessage(Constants.ERR_404), "ID: " + id));
    }

    private void validateUpdate(TblUserUpdateRequest request, CommonStatus status) {
        TblUser existsUser = userRepository.findByEmailAndStatus(request.getEmail(), CommonStatus.ACTIVE);
        if (Objects.nonNull(existsUser) && !existsUser.getId().equals(request.getId())) {
            throw new BusinessException(MessageCode.ERR_01003, messageUtil.getMessage(MessageCode.ERR_01003), "Email: " + request.getEmail() + ", Status: " + CommonStatus.ACTIVE);
        }
        if (CommonStatus.ACTIVE.equals(status) && CommonStatus.INACTIVE.equals(status)) {
            throw new BusinessException(MessageCode.ERR_01004, messageUtil.getMessage(MessageCode.ERR_01004), "Status: " + request.getStatus());
        }
    }
}
