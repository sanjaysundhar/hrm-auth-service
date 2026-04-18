package com.hrm.auth_service.common;

public record ApiResponse<T> (

        T data,

        String message,

        Object errorData

)

{ }
