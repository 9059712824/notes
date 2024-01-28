package org.learning.notes.service.impl;

import lombok.RequiredArgsConstructor;
import org.learning.notes.dto.RegisterRequestDto;
import org.learning.notes.dto.RegisterResponseDto;
import org.learning.notes.mapper.UserMapper;
import org.learning.notes.repository.UserRepository;
import org.learning.notes.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public Mono<RegisterResponseDto> register(RegisterRequestDto registerDto) {
        if (!registerDto.getPassword().equals(registerDto.getConfirmPassword())) {
            return Mono.error(new Exception("Password Not Matched"));
        }
        return Mono.just(registerDto)
                .map(userMapper::registerRequestDtoToUser)
                .map(user -> {
                    user.setPassword(passwordEncoder.encode(user.getPassword()));
                    return user;
                })
                .flatMap(userRepository::save)
                .map(userMapper::userToRegisterResponseDto);
    }
}
