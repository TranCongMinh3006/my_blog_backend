package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "role", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "role_uk", columnNames = "role_name") })
public class RoleEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "role_name", length = 30, nullable = false)
    private String roleName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="roleEntity")
    @JsonIgnore
    private Set<UserRoleEntity> userRoleEntitySet;


}