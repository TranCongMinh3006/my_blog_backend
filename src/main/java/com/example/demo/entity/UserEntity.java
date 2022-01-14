package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Table(name = "user")
@Getter
@Setter
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String userName;
    private String mobile;
    private String email;
    private String passwordHash;
    private Date registeredAt;
    private Date lastLogin;
    private String intro;
    private String profile;

    @OneToMany(mappedBy="authorId")
    @JsonIgnore
    private Set<PostEntity> postEntitySet;

    @OneToMany(fetch = FetchType.EAGER,mappedBy="userEntity")
    @JsonIgnore
    private Set<UserRoleEntity> userRoleEntitySet;

    public UserEntity(){}
    public UserEntity(Long id){
        this.id = id;
    }

//    CREATE SCHEMA `blog` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

}
