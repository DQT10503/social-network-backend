package com.source_user_authen.service.impl;

import com.api.framework.domain.DeleteMethodResponse;
import com.api.framework.domain.PagingResponse;
import com.api.framework.exception.BusinessException;
import com.api.framework.service.CommonService;
import com.api.framework.utils.Constants;
import com.api.framework.utils.MessageUtil;
import com.api.framework.utils.SimpleQueryBuilder;
import com.api.framework.utils.Utilities;
import com.source_user_authen.domain.user_device.*;
import com.source_user_authen.entity.TblUserDevice;
import com.source_user_authen.repository.TblUserDeviceRepository;
import com.source_user_authen.service.TblUserDeviceService;
import com.source_user_authen.utils.MessageCode;
import com.source_user_authen.utils.enummerate.CommonStatus;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TblUserDeviceServiceImpl implements TblUserDeviceService {

    private final CommonService commonService;
    private final MessageUtil messageUtil;
    private final TblUserDeviceRepository userDeviceRepository;

    public TblUserDeviceServiceImpl(CommonService commonService, MessageUtil messageUtil, TblUserDeviceRepository userDeviceRepository) {
        this.commonService = commonService;
        this.messageUtil = messageUtil;
        this.userDeviceRepository = userDeviceRepository;
    }


    @Override
    public PagingResponse search(TblUserDeviceRequest request, Pageable pageRequest) {
        StringBuilder whereClause = new StringBuilder("1 = 1");
        Map<String, Object> params = new HashMap<>();
        SimpleQueryBuilder simpleQueryBuilder = new SimpleQueryBuilder();
        Utilities.buildWhereClause(request, params);

        simpleQueryBuilder.where(whereClause.toString());
        simpleQueryBuilder.from("tbl_user_device");

        PagingResponse pagingRs = commonService.executeSearchData(pageRequest, simpleQueryBuilder, params, TblUserDevice.class);
        List<TblUserDevice> datas = (List<TblUserDevice>) pagingRs.getData();
        List<TblUserDeviceResponse> caseResponses = Utilities.copyProperties(datas, TblUserDeviceResponse.class);
        pagingRs.setData(caseResponses);
        return pagingRs;
    }

    @Override
    public TblUserDeviceResponse insert(TblUserDeviceCreateRequest request) {
        TblUserDevice userDevice = Utilities.copyProperties(request, TblUserDevice.class);
        userDevice.setStatus(CommonStatus.ACTIVE);
        userDeviceRepository.save(userDevice);
        return Utilities.copyProperties(userDevice, TblUserDeviceResponse.class);
    }

    @Override
    public TblUserDeviceResponse update(TblUserDeviceUpdateRequest request) {
        TblUserDevice userDevice = getUserDeviceById(request.getId());
        Utilities.updateProperties(request, userDevice);
        userDeviceRepository.save(userDevice);
        return Utilities.copyProperties(userDevice, TblUserDeviceResponse.class);
    }

    @Override
    public DeleteMethodResponse delete(Long id) {
        TblUserDevice userDevice = getUserDeviceById(id);
        if (!CommonStatus.INACTIVE.equals(userDevice.getStatus())) {
            throw new BusinessException(MessageCode.ERR_STATUS, messageUtil.getMessage(MessageCode.ERR_STATUS), "Status: " + CommonStatus.ACTIVE);
        }
        userDeviceRepository.delete(userDevice);
        DeleteMethodResponse response = new DeleteMethodResponse();
        response.setId(id);
        return response;
    }

    @Override
    public TblUserDeviceDetailResponse detail(Long id) {
        TblUserDevice userDevice = getUserDeviceById(id);
        return Utilities.copyProperties(userDevice, TblUserDeviceDetailResponse.class);
    }

    private TblUserDevice getUserDeviceById(Long id) {
        return userDeviceRepository.findById(id).orElseThrow(() -> new BusinessException(Constants.ERR_404, messageUtil.getMessage(Constants.ERR_404), "Id: " + id));
    }
}
