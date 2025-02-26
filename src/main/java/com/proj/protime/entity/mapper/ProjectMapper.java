package com.proj.protime.entity.mapper;

import com.proj.protime.entity.Projects;
import com.proj.protime.entity.dto.projects.ProjectsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProjectMapper {

    ProjectsDTO toProjectDTOPut(Projects project);

    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    @Mapping(target = "id", ignore = true)
    void updateProject(
            @MappingTarget Projects project,
            Projects projectPut
    );

}
