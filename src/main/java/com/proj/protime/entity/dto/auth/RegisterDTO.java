package com.proj.protime.entity.dto.auth;

import com.proj.protime.entity.enums.ProfileUser;

import jakarta.validation.constraints.NotBlank;

public record RegisterDTO(
        @NotBlank String name,
        @NotBlank String email,
        @NotBlank String password,
        ProfileUser profile) {
	
}
