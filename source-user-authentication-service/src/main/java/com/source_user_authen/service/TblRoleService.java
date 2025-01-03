package com.source_user_authen.service;

import com.api.framework.domain.DeleteMethodResponse;
import com.api.framework.domain.PagingResponse;
import com.source_user_authen.domain.role.TblRoleCreateRequest;
import com.source_user_authen.domain.role.TblRoleDetailResponse;
import com.source_user_authen.domain.role.TblRoleResponse;
import com.source_user_authen.domain.role.TblRoleUpdateRequest;

public interface TblRoleService {

    TblRoleResponse insert(TblRoleCreateRequest request);

    TblRoleResponse update(TblRoleUpdateRequest request);

    DeleteMethodResponse delete(Long id);

    TblRoleDetailResponse detail(Long id);

}
