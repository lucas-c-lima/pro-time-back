package com.proj.protime.entity.dto.projects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proj.protime.entity.dto.users.UsersDTO;
import com.proj.protime.entity.enums.ProjectPriority;
import com.proj.protime.entity.enums.ProjectStatus;

import java.time.LocalDateTime;

public record ProjectsDTO(
        Integer id,
        String name,
        String description,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime startDate,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime endDate,
        ProjectStatus status,
        UsersDTO idResponsableUser,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime creationDate,
        ProjectPriority priority
) {
    public ProjectsDTO(com.proj.protime.entity.Projects project) {
        this(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getStartDate(),
                project.getEndDate(),
                project.getStatus(),
                new UsersDTO(project.getIdResponsableUser()),
                project.getCreationDate(),
                project.getPriority()
        );
    }
}
