package com.hrm.auth_service.company.mapper;

import com.hrm.auth_service.company.entity.Company;
import com.hrm.auth_service.company.request.CompanyRequest;
import com.hrm.auth_service.company.response.CompanyResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    Company toEntity(CompanyRequest request);

    CompanyResponse toResponse(Company request);

}
