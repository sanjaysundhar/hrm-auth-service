package com.hrm.auth_service.company.repository;

import com.hrm.auth_service.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    boolean existsByIdentifierName(String identifierName);
    boolean existsByEmail(String email);
    boolean existsByPhoneCodeAndPhoneNumber(String phoneCode, String phoneNumber);

}
