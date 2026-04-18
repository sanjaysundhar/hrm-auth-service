package com.hrm.auth_service.user.request;

public record UserRequest(

        String firstName,

        String lastName,

        String userName,

        String email,

        String phoneCode,

        String phoneNumber

) {
}
