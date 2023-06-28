package com.bookstore.bookstore.service;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.bookstore.bookstore.model.Role;
import com.bookstore.bookstore.repository.RoleRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements  RoleService{

    private final RoleRepository roleRepository;

    public static final String DEFAULT_ROLE = "ROLE_USER";

    @PostConstruct
    public void init() {
        if (!roleRepository.getRoleByName(DEFAULT_ROLE).isPresent()) {
            roleRepository.save(Role.builder().name(DEFAULT_ROLE).build());
        }
    }

    @Override
    public Role findRoleByName(String name) {
        return roleRepository.getRoleByName(name)
                .orElseThrow(()-> new RuntimeException("Role with name " + name + " not found"));
    }



}

