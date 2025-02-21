package com.proj.protime.entities.enums;

public enum ProfileUser {
	ADMIN("admin"),
    USUARIO("usuario");
	
	private String profile;
	
	ProfileUser(String profile) {
		this.profile = profile;
	}
	
	public String getProfile() {
		return profile;
	}
}
