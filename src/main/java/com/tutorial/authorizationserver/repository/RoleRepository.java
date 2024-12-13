package com.tutorial.authorizationserver.repository;

import com.tutorial.authorizationserver.entity.Role;
import com.tutorial.authorizationserver.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRole(RoleName roleName);
}