package com.hrm.auth_service.permission;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "permission",
        uniqueConstraints = @UniqueConstraint(columnNames = "name", name = "uk_permission_name")
)
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;

    private String description;
}
