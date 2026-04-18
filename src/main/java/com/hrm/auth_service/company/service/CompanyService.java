package com.hrm.auth_service.company.service;

import com.hrm.auth_service.appConfig.CurrencyConfig;
import com.hrm.auth_service.common.ErrorConstants;
import com.hrm.auth_service.company.entity.Company;
import com.hrm.auth_service.company.mapper.CompanyMapper;
import com.hrm.auth_service.company.repository.CompanyRepository;
import com.hrm.auth_service.company.request.CompanyRequest;
import com.hrm.auth_service.company.response.CompanyResponse;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CurrencyConfig currencyConfig;
    private final CompanyMapper companyMapper;

    public CompanyService(CompanyRepository companyRepository, CurrencyConfig currencyConfig, CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.currencyConfig = currencyConfig;
        this.companyMapper = companyMapper;
    }

    public CompanyResponse createCompany(CompanyRequest request){

        if (!currencyConfig.getSupportedCurrencies().contains(request.currency())){
            throw new IllegalArgumentException(ErrorConstants.CURRENCY_NOT_SUPPORTED);
        }

        if (companyRepository.existsByIdentifierName(request.identifierName())){
            throw new IllegalArgumentException(ErrorConstants.COMPANY_ALREADY_EXIST);
        }

        if (companyRepository.existsByEmail(request.email())){
            throw new IllegalArgumentException(ErrorConstants.EMAIL_ALREADY_EXIST);
        }

        if (companyRepository.existsByPhoneCodeAndPhoneNumber(request.phoneCode(), request.phoneNumber())){
            throw new IllegalArgumentException(ErrorConstants.PHONE_NUMBER_ALREADY_EXIST);
        }

        Company company = companyMapper.toEntity(request);

        companyRepository.save(company);

        return companyMapper.toResponse(company);

    }

}
