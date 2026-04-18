package com.hrm.auth_service.user.response;

public record UserResponse (

        Integer id,

        String firstName,

        String lastName,

        String userName,

        String email,

        String phoneCode,

        String phoneNumber
)
{ }
