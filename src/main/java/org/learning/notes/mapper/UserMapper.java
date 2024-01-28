package org.learning.notes.mapper;

import org.learning.notes.dto.RegisterRequestDto;
import org.learning.notes.dto.RegisterResponseDto;
import org.learning.notes.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    User registerRequestDtoToUser(RegisterRequestDto registerRequestDto);

    RegisterResponseDto userToRegisterResponseDto(User user);
}
