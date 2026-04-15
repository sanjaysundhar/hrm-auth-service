package com.hrm.auth_service.permission;

import com.hrm.auth_service.role.entity.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "role_permission_mapping",
        uniqueConstraints = @UniqueConstraint(columnNames = {"role_id","permission_id"}, name = "uk_role_permission")
)
public class RolePermissionMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "permission_id", nullable = false)
    private Permission permission;
}
