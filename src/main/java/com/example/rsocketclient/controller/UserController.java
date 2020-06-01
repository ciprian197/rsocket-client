package com.example.rsocketclient.controller;

import com.example.rsocketclient.dto.UserCreationDto;
import com.example.rsocketclient.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final RSocketRequester rSocketRequester;

    @PostMapping
    public Mono<UserDto> createUser(final @RequestBody @Valid UserCreationDto creationDto) {
        return rSocketRequester
                .route("createUser")
                .data(creationDto)
                .retrieveMono(UserDto.class);
    }

}

