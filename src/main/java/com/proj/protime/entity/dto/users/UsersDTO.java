package com.proj.protime.entity.dto.users;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proj.protime.entity.Users;
import com.proj.protime.entity.enums.ProfileUser;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

public record UsersDTO(
        Integer id,
        String name,
        String email,
        String password,
        ProfileUser profile,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime creationDate,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime lastLogin
) {
    public UsersDTO(Users user) {
        this(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getProfile(),
                user.getCreationDate(),
                user.getLastLogin()
        );
    }
}
