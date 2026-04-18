package com.hrm.auth_service.user.service;

import com.hrm.auth_service.common.Constants;
import com.hrm.auth_service.common.ErrorConstants;
import com.hrm.auth_service.user.entity.User;
import com.hrm.auth_service.user.mapper.UserMapper;
import com.hrm.auth_service.user.repository.UserRepository;
import com.hrm.auth_service.user.request.UserRequest;
import com.hrm.auth_service.user.response.UserResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.constant.Constable;

@Service
public class UserService {

    public final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse createUser(UserRequest request){

        if (userRepository.existsByUserName(request.userName())){
            throw new IllegalArgumentException(ErrorConstants.USER_NAME_EXIST);
        }

        if (userRepository.existsByEmail(request.email())){
            throw new IllegalArgumentException(ErrorConstants.EMAIL_ALREADY_EXIST);
        }

        if (userRepository.existsByPhoneCodeAndPhoneNumber(request.phoneCode(), request.phoneNumber())){
            throw new IllegalArgumentException(ErrorConstants.PHONE_NUMBER_ALREADY_EXIST);
        }

        User user = userMapper.toEntity(request);

        user.setPassword(passwordEncoder.encode(Constants.FIRST_LOG_IN_PASSWORD));
        user.setFirstLogin(true);

        userRepository.save(user);

        return userMapper.toResponse(user);

    }
}
