package com.tutorial.authorizationserver.dto;

import java.util.Set;

public record CreateAppUserDTO(
        String username,
        String password,
        Set<String> roles) {
}
