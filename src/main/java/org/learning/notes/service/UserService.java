package org.learning.notes.service;

import org.learning.notes.dto.RegisterRequestDto;
import org.learning.notes.dto.RegisterResponseDto;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<RegisterResponseDto> register(RegisterRequestDto registerDto);
}
