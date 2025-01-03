package com.source_user_authen.service;

import com.api.framework.domain.DeleteMethodResponse;
import com.source_user_authen.domain.user_role.TblUserRoleCreateRequest;
import com.source_user_authen.domain.user_role.TblUserRoleResponse;
import com.source_user_authen.domain.user_role.TblUserRoleUpdateRequest;

public interface TblUserRoleService {

    TblUserRoleResponse insert(TblUserRoleCreateRequest request);

    TblUserRoleResponse update(TblUserRoleUpdateRequest request);

    DeleteMethodResponse delete(Long userId, Long roleId);
}
