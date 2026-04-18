package com.hrm.auth_service.company.controller;

import com.hrm.auth_service.common.ApiResponse;
import com.hrm.auth_service.common.Constants;
import com.hrm.auth_service.company.request.CompanyRequest;
import com.hrm.auth_service.company.response.CompanyResponse;
import com.hrm.auth_service.company.service.CompanyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("company")
public class CompanyController {

    public final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/create")
    public ApiResponse<CompanyResponse> createCompany(@RequestBody CompanyRequest request){

        return new ApiResponse<>(companyService.createCompany(request), Constants.SUCCESS_MESSAGE,null);

    }
}
