package com.source_user_authen.service;

import com.api.framework.domain.DeleteMethodResponse;
import com.api.framework.domain.PagingResponse;
import com.source_user_authen.domain.user.TblUserResponse;
import com.source_user_authen.domain.user_device.*;
import com.source_user_authen.entity.TblUserDevice;
import org.springframework.data.domain.Pageable;

public interface TblUserDeviceService {

    PagingResponse search(TblUserDeviceRequest request, Pageable pageRequest);

    TblUserDeviceResponse insert(TblUserDeviceCreateRequest request);

    TblUserDeviceResponse update(TblUserDeviceUpdateRequest request);

    DeleteMethodResponse delete(Long id);

    TblUserDeviceDetailResponse detail(Long id);
}
