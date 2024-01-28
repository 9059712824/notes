package org.learning.notes.controller;

import lombok.RequiredArgsConstructor;
import org.learning.notes.dto.RegisterRequestDto;
import org.learning.notes.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public Mono<ResponseEntity.BodyBuilder> register(@RequestBody RegisterRequestDto registerDto) {
        return userService.register(registerDto)
                .map(savedUser -> ResponseEntity.status(HttpStatus.CREATED))
                .onErrorReturn(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR));

    }
}
