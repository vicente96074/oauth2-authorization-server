package com.tutorial.authorizationserver.service;

import com.tutorial.authorizationserver.dto.CreateAppUserDTO;
import com.tutorial.authorizationserver.dto.MessageDTO;
import com.tutorial.authorizationserver.entity.AppUser;
import com.tutorial.authorizationserver.entity.Role;
import com.tutorial.authorizationserver.enums.RoleName;
import com.tutorial.authorizationserver.repository.AppUserRepository;
import com.tutorial.authorizationserver.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class AppUserService {

    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public MessageDTO createUser(CreateAppUserDTO dto) {
        AppUser appUser = AppUser.builder()
                .username(dto.username())
                .password(passwordEncoder.encode(dto.password()))
                .build();

        Set<Role> roles = new HashSet<>();
        dto.roles().forEach(r -> {
            Role role = roleRepository.findByRole(RoleName.valueOf(r))
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(role);
        });

        appUser.setRoles(roles);
        appUserRepository.save(appUser);

        return new MessageDTO(String.format("User %s registered successfully!", dto.username()));
    }
}