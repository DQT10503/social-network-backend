package com.source_user_authen.controller;

import com.api.framework.domain.DeleteMethodResponse;
import com.api.framework.domain.PagingRequest;
import com.api.framework.domain.PagingResponse;
import com.api.framework.security.BearerContextHolder;
import com.source_user_authen.domain.user_device.*;
import com.source_user_authen.service.TblUserDeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(description = "Module User Device")
@RestController
@RequestMapping("/user-device")
public class TblUserDeviceController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final TblUserDeviceService userDeviceService;

    public TblUserDeviceController(TblUserDeviceService userDeviceService) {
        this.userDeviceService = userDeviceService;
    }

    @ApiOperation(value = "Lấy danh sách thiết bị của người dùng")
    @GetMapping
    public ResponseEntity<PagingResponse> search(TblUserDeviceRequest request, PagingRequest pagingRequest) {
        String masterAccount = BearerContextHolder.getContext().getMasterAccount();
        logger.info("{} [Filter] {}", masterAccount, request);
        Pageable pageRequest = PageRequest.of(pagingRequest.getOffset(), pagingRequest.getLimit(), pagingRequest.getSort(Sort.by(Sort.Direction.DESC, "lastLogin")));
        return ResponseEntity.ok(userDeviceService.search(request, pageRequest));
    }

    @ApiOperation(value = "Thêm mới user device")
    @PostMapping
    public ResponseEntity<TblUserDeviceResponse> insert(@RequestBody @Valid TblUserDeviceCreateRequest request) {
        String masterAccount = BearerContextHolder.getContext().getMasterAccount();
        logger.info("{} [Insert] {}", masterAccount, request);
        return ResponseEntity.ok(userDeviceService.insert(request));
    }

    @ApiOperation(value = "Cập nhật user device")
    @PutMapping
    public ResponseEntity<TblUserDeviceResponse> update(@RequestBody @Valid TblUserDeviceUpdateRequest request) {
        String masterAccount = BearerContextHolder.getContext().getMasterAccount();
        logger.info("{} [Update] {}", masterAccount, request);
        return ResponseEntity.ok(userDeviceService.update(request));
    }

    @ApiOperation(value = "Xóa user device")
    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteMethodResponse> delete(@PathVariable("id") Long id) {
        String masterAccount = BearerContextHolder.getContext().getMasterAccount();
        logger.info("{} [Delete] {}", masterAccount, id );
        return ResponseEntity.ok(userDeviceService.delete(id));
    }

    @ApiOperation(value = "Chi tiết user device")
    @GetMapping("/{id}")
    public ResponseEntity<TblUserDeviceDetailResponse> detail(@PathVariable("id") Long id) {
        String masterAccount = BearerContextHolder.getContext().getMasterAccount();
        logger.info("{} [Detail] {}", masterAccount, id );
        return ResponseEntity.ok(userDeviceService.detail(id));
    }
}
