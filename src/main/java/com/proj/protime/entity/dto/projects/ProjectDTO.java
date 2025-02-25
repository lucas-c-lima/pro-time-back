package com.proj.protime.entity.dto.projects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proj.protime.entity.Users;
import com.proj.protime.entity.dto.users.UsersDTO;
import com.proj.protime.entity.enums.ProjectPriority;
import com.proj.protime.entity.enums.ProjectStatus;

import java.time.LocalDateTime;

public record ProjectDTO(
        Integer id,
        String name,
        String description,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime startDate,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime data_fim,
        ProjectStatus status,
        UsersDTO idResponsableUser,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime creationDate,
        ProjectPriority priority
) {
    public ProjectDTO(com.proj.protime.entity.Projects project) {
        this(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getStartDate(),
                project.getData_fim(),
                project.getStatus(),
                new UsersDTO(project.getIdResponsableUser()),
                project.getCreationDate(),
                project.getPriority()
        );
    }
}
