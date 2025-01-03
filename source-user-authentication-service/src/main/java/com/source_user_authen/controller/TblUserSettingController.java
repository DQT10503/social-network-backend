package com.source_user_authen.controller;

import com.api.framework.domain.DeleteMethodResponse;
import com.api.framework.security.BearerContextHolder;
import com.source_user_authen.domain.user_setting.TblUserSettingDetailResponse;
import com.source_user_authen.domain.user_setting.TblUserSettingResponse;
import com.source_user_authen.domain.user_setting.TblUserSettingUpdateRequest;
import com.source_user_authen.service.TblUserSettingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(description = "Module User Setting")
@RestController
@RequestMapping("/user-setting")
public class TblUserSettingController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final TblUserSettingService userSettingService;

    public TblUserSettingController(TblUserSettingService userSettingService) {
        this.userSettingService = userSettingService;
    }

    @ApiOperation(value = "Cập nhật user setting")
    @PutMapping
    public ResponseEntity<TblUserSettingResponse> update(@RequestBody @Valid TblUserSettingUpdateRequest request) {
        String masterAccount = BearerContextHolder.getContext().getMasterAccount();
        logger.info("{} [Update] {}", masterAccount, request);
        return ResponseEntity.ok(userSettingService.update(request));
    }

    @ApiOperation(value = "Xóa user setting")
    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteMethodResponse> delete(@PathVariable("/id") Long id) {
        String masterAccount = BearerContextHolder.getContext().getMasterAccount();
        logger.info("{} [Delete] {}", masterAccount, id);
        return ResponseEntity.ok(userSettingService.delete(id));
    }

    @ApiOperation(value = "Chi tiết user setting")
    @GetMapping("/{id}")
    public ResponseEntity<TblUserSettingDetailResponse> detail(@PathVariable("/id") Long id) {
        String masterAccount = BearerContextHolder.getContext().getMasterAccount();
        logger.info("{} [Detail] {}", masterAccount, id);
        return ResponseEntity.ok(userSettingService.detail(id));
    }
}
