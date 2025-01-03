package com.source_user_authen.controller;

import com.api.framework.domain.DeleteMethodResponse;
import com.api.framework.domain.PagingRequest;
import com.api.framework.domain.PagingResponse;
import com.api.framework.security.BearerContextHolder;
import com.source_user_authen.domain.user.*;
import com.source_user_authen.service.TblUserService;
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

@Api(description = "Module User")
@RestController
@RequestMapping("/user")
public class TblUserController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final TblUserService userService;

    public TblUserController(TblUserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Lấy danh sách user, có phân trang")
    @GetMapping
    public ResponseEntity<PagingResponse> search(TblUserRequest request, PagingRequest pagingRequest) {
        String masterAccount = BearerContextHolder.getContext().getMasterAccount();
        logger.info("{} [Filter] {}", masterAccount, request);
        Pageable pageRequest = PageRequest.of(pagingRequest.getOffset(), pagingRequest.getLimit(), pagingRequest.getSort(Sort.by(Sort.Direction.ASC, "full_name")));
        return ResponseEntity.ok(userService.search(request, pageRequest));
    }

    @ApiOperation(value = "Thêm mới user")
    @PostMapping
    private ResponseEntity<TblUserResponse> insert(@RequestBody @Valid TblUserCreateRequest request) {
        String masterAccount = BearerContextHolder.getContext().getMasterAccount();
        logger.info("{} [Insert] {}", masterAccount, request);
        return ResponseEntity.ok(userService.insert(request));
    }

    @ApiOperation(value = "Cập nhật user")
    @PutMapping
    private ResponseEntity<TblUserResponse> update(@RequestBody @Valid TblUserUpdateRequest request) {
        String masterAccount = BearerContextHolder.getContext().getMasterAccount();
        logger.info("{} [Update] {}", masterAccount, request);
        return ResponseEntity.ok(userService.update(request));
    }

    @ApiOperation(value = "Xóa user")
    @DeleteMapping("/{id}")
    private ResponseEntity<DeleteMethodResponse> delete(@PathVariable("id") Long id) {
        String masterAccount = BearerContextHolder.getContext().getMasterAccount();
        logger.info("{} [Delete] {}", masterAccount, id);
        return ResponseEntity.ok(userService.delete(id));
    }

    @ApiOperation(value = "Chi tiết user")
    @GetMapping("/{id}")
    private ResponseEntity<TblUserDetailResponse> detail(@PathVariable("id") Long id) {
        String masterAccount = BearerContextHolder.getContext().getMasterAccount();
        logger.info("{} [Detail] {}", masterAccount, id);
        return ResponseEntity.ok(userService.detail(id));
    }
}
