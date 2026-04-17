package com.hrm.auth_service.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "user",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "user_name", name = "uk_user_name"),
                @UniqueConstraint(columnNames = {"phone_code","phone_number"} , name = "uk_phone_code_phone_number_user"),
                @UniqueConstraint(columnNames = "email", name = "uk_user_email"),
        }
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(name = "user_name", nullable = false, length = 50)
    private String userName;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(name = "phone_code", nullable = false, length = 5)
    private String phoneCode;

    @Column(name = "phone_number", nullable = false, length = 15)
    private String phoneNumber;

    @Column(nullable = false)
    private String password;

}
