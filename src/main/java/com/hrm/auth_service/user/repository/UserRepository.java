package com.hrm.auth_service.user.repository;

import com.hrm.auth_service.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByUserName(String userName);

    boolean existsByPhoneCodeAndPhoneNumber(String phoneCode, String phoneNumber);

    boolean existsByEmail(String email);
}
