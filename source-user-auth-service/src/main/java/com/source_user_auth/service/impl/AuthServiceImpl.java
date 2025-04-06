package com.source_user_auth.service.impl;

import com.api.framework.exception.BusinessException;
import com.api.framework.utils.MessageUtil;
import com.api.framework.utils.Utilities;
import com.source_user_auth.domain.auth.RegisterRequest;
import com.source_user_auth.domain.auth.RegisterResponse;
import com.source_user_auth.entity.TblUser;
import com.source_user_auth.repository.TblRoleRepository;
import com.source_user_auth.repository.TblUserRepository;
import com.source_user_auth.repository.TblUserRoleRepository;
import com.source_user_auth.service.AuthService;
import com.source_user_auth.service.KeyCloakService;
import com.source_user_auth.utils.MessageCode;
import com.source_user_auth.utils.enummerate.AuthStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Random;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {
    private final TblUserRepository userRepository;
    private final TblUserRoleRepository userRoleRepository;
    private final TblRoleRepository roleRepository;
    private final MessageUtil messageUtil;
    private final KeyCloakService keyCloakService;

    public AuthServiceImpl(TblUserRepository userRepository, TblUserRoleRepository userRoleRepository, TblRoleRepository roleRepository, MessageUtil messageUtil, KeyCloakService keyCloakService) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.roleRepository = roleRepository;
        this.messageUtil = messageUtil;
        this.keyCloakService = keyCloakService;
    }

    @Override
    public RegisterResponse register(RegisterRequest request) {
        TblUser existsUser = userRepository.findByEmailAndPhoneAndStatus(request.getEmail(), request.getPhone(), AuthStatus.ACTIVE);
        if (Objects.nonNull(existsUser)) {
            throw new BusinessException(MessageCode.DUPLICATE, messageUtil.getMessage(MessageCode.DUPLICATE), "Email: " + request.getEmail() + ", Phone: " + request.getPhone() + ", Status: " + AuthStatus.ACTIVE);
        }
        TblUser user = Utilities.copyProperties(request, TblUser.class);
        user.setStatus(AuthStatus.ACTIVE);
        user.setAvatarUrl("abc.jpg");
        user.setUsername(generateUsername());
        keyCloakService.createUserInKeycloak(user.getFullName(), user.getEmail(), user.getUsername(), user.getPassword(), user.getPhone());
//        userRepository.save(user);
//        TblRole role = roleRepository.findByName(RoleEnum.ROLE_USER);
//        TblUserRole userRole = new TblUserRole();
//        userRole.setId(new TblUserRoleId(user.getId(), role.getId()));
//        userRoleRepository.save(userRole);

        return Utilities.copyProperties(user, RegisterResponse.class);
    }

    private String generateUsername() {
        Random random = new Random();
        String username;
        do {
            username = String.valueOf(10000 + random.nextInt(900000));
        } while (userRepository.existsByUsername(username));
        return username;
    }

}
