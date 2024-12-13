package com.tutorial.authorizationserver.controller;

import com.tutorial.authorizationserver.dto.CreateClientDTO;
import com.tutorial.authorizationserver.dto.MessageDTO;
import com.tutorial.authorizationserver.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
@Slf4j
public class ClientController {

    @PostMapping("/create")
    public ResponseEntity<MessageDTO> create(@RequestBody CreateClientDTO dto) {
        log.info("Creating client with clientId: {}", dto.getClientId());
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.create(dto));
    }

    private final ClientService clientService;
}