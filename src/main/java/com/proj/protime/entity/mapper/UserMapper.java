package com.proj.protime.entity.mapper;

import com.proj.protime.entity.Users;

import com.proj.protime.entity.dto.users.UsersDTO;
import com.proj.protime.entity.dto.users.UsersDTOPut;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UsersDTO toUsersDTOPut(Users user);

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", ignore = true)
    void updateUser(
            @MappingTarget Users user,
            UsersDTOPut userDTOPut
    );

}
