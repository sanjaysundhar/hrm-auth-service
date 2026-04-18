package com.hrm.auth_service.company.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "company",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "identifier_name", name = "uk_identifierName"),
                @UniqueConstraint(columnNames = {"phone_code","phone_number"} , name = "uk_phone_code_phone_number_company"),
                @UniqueConstraint(columnNames = "email", name = "uk_company_email"),

        }
)
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "identifier_name", nullable = false, length = 100)
    private String identifierName;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(name = "phone_code", nullable = false, length = 5)
    private String phoneCode;

    @Column(name = "phone_number", nullable = false, length = 15)
    private String phoneNumber;

    @Column(nullable = false, length = 3)
    private String currency;

    @Column(nullable = true, length = 30)
    private String website;

    @Column(nullable = false, length = 25)
    private String addressLine1;

    @Column(nullable = false, length = 25)
    private String addressLine2;

    @Column(nullable = false, length = 50)
    private String city;

    @Column(nullable = false, length = 50)
    private String state;

    @Column(nullable = false, length = 50)
    private String country;

    @Column(nullable = false, length = 10)
    private String postalCode;
}
