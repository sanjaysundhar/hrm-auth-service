package com.hrm.auth_service.company.response;

public record CompanyResponse(

        Integer id,

        String name,

        String identifierName,

        String email,

        String phoneCode,

        String phoneNumber,

        String currency,

        String website,

        String addressLine1,

        String addressLine2,

        String city,

        String state,

        String country,

        String postalCode

) {
}
