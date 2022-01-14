package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.example.demo.entity.RoleEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.entity.UserRoleEntity;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = this.userRepository.findByUserName(userName);

        if (userEntity == null) {
            System.out.println("User not found! " + userEntity);
            throw new UsernameNotFoundException("User " + userEntity + " was not found in the database");
        }

        System.out.println("Found User: " + userEntity);

        // [ROLE_USER, ROLE_ADMIN,..]
        Set<UserRoleEntity> userRoleEntitySet = userEntity.getUserRoleEntitySet();

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

        if(!userRoleEntitySet .isEmpty()){
            for(UserRoleEntity userRoleEntity : userRoleEntitySet){
                Optional<RoleEntity> roleEntity = this.roleRepository.findById(userRoleEntity.getRoleEntity().getId());
                if (roleEntity.isPresent()) {
                    GrantedAuthority authority = new SimpleGrantedAuthority(roleEntity.get().getRoleName());
                    grantList.add(authority);
                }
            }
        }

        UserDetails userDetails = new User(userEntity.getUserName(), //
                userEntity.getPasswordHash(), grantList);

        return userDetails;
    }

}