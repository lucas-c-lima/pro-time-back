package com.proj.protime.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ProfileUser {
	ADMIN,
	USUARIO;

	@JsonCreator
	public static ProfileUser getProfileUser(String profileUser) {
		if (ADMIN.name().equals(profileUser)) {
			return ADMIN;
		} else if (USUARIO.name().equals(profileUser)) {
			return USUARIO;
		}
		return null;
	}
}
