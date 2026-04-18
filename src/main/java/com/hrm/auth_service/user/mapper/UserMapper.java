package com.hrm.auth_service.user.mapper;

import com.hrm.auth_service.user.entity.User;
import com.hrm.auth_service.user.request.UserRequest;
import com.hrm.auth_service.user.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    User toEntity(UserRequest request);

    UserResponse toResponse(User request);

}
