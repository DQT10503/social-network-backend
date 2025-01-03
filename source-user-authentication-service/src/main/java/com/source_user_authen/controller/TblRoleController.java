package com.source_user_authen.controller;

import com.api.framework.domain.DeleteMethodResponse;
import com.api.framework.security.BearerContextHolder;
import com.source_user_authen.domain.role.TblRoleCreateRequest;
import com.source_user_authen.domain.role.TblRoleDetailResponse;
import com.source_user_authen.domain.role.TblRoleResponse;
import com.source_user_authen.domain.role.TblRoleUpdateRequest;
import com.source_user_authen.service.TblRoleService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(description = "Module Role")
@RestController
@RequestMapping("/role")
public class TblRoleController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final TblRoleService roleService;

    public TblRoleController(TblRoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<TblRoleResponse> insert(@RequestBody @Valid TblRoleCreateRequest request) {
        String masterAccount = BearerContextHolder.getContext().getMasterAccount();
        logger.info("{} [Insert] {}", masterAccount, request);
        return ResponseEntity.ok(roleService.insert(request));
    }

    @PutMapping
    public ResponseEntity<TblRoleResponse> update(@RequestBody @Valid TblRoleUpdateRequest request) {
        String masterAccount = BearerContextHolder.getContext().getMasterAccount();
        logger.info("{} [Update] {}", masterAccount, request);
        return ResponseEntity.ok(roleService.update(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteMethodResponse> delete(@PathVariable("id") Long id) {
        String masterAccount = BearerContextHolder.getContext().getMasterAccount();
        logger.info("{} [Delete] {}", masterAccount, id);
        return ResponseEntity.ok(roleService.delete(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TblRoleDetailResponse> detail(@PathVariable("id") Long id) {
        String masterAccount = BearerContextHolder.getContext().getMasterAccount();
        logger.info("{} [Detail] {}", masterAccount, id);
        return ResponseEntity.ok(roleService.detail(id));
    }
}
