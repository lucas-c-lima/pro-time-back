package com.proj.protime.entity.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO( String email, String password) {

}
