package com.proj.protime.entity.dto.users;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proj.protime.entity.Users;
import com.proj.protime.entity.enums.ProfileUser;

import java.time.LocalDateTime;

public record UsersDTOPut(
        String name,
        String email,
        String password,
        ProfileUser profile
) {
    public UsersDTOPut(Users user) {
        this(
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getProfile()
        );
    }
}
