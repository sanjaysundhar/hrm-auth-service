package com.hrm.auth_service.company.entity;

import com.hrm.auth_service.role.entity.Role;
import com.hrm.auth_service.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "company_user_mapping",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"company_id","user_id"}, name = "uk_company_user")
        }
)
public class CompanyUserMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (nullable = false)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Role role;


}
