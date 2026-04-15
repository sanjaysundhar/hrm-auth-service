package com.hrm.auth_service.role.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "role",
        uniqueConstraints = @UniqueConstraint(columnNames = "role", name = "uk_role_name")
)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;

    private String description;
}
