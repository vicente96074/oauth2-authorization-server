/*
package com.tutorial.authorizationserver.config;

import com.tutorial.authorizationserver.entity.Role;
import com.tutorial.authorizationserver.enums.RoleName;
import com.tutorial.authorizationserver.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Creator implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Role adminRole = Role.builder().role(RoleName.ROLE_ADMIN).build();
        Role userRole = Role.builder().role(RoleName.ROLE_USER).build();

        roleRepository.save(adminRole);
        roleRepository.save(userRole);
    }

    private final RoleRepository roleRepository;
}
*/
