package com.hrm.auth_service.user.controller;

import com.hrm.auth_service.common.ApiResponse;
import com.hrm.auth_service.common.Constants;
import com.hrm.auth_service.user.request.UserRequest;
import com.hrm.auth_service.user.response.UserResponse;
import com.hrm.auth_service.user.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public ApiResponse<UserResponse> createUser(@RequestBody UserRequest request){

        return new ApiResponse<>(userService.createUser(request), Constants.SUCCESS_MESSAGE, null);

    }

}
