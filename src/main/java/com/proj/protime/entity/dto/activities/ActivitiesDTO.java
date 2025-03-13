package com.proj.protime.entity.dto.activities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proj.protime.entity.dto.projects.ProjectsDTO;
import com.proj.protime.entity.dto.users.UsersDTO;
import com.proj.protime.entity.enums.ActivityStatus;

import java.time.LocalDateTime;

public record ActivitiesDTO(
        Integer id,
        ProjectsDTO idProjects,
        String name,
        String description,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime startDate,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime endDate,
        ActivityStatus status,
        UsersDTO idResponsableUser,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime creationDate
) {
    public ActivitiesDTO(com.proj.protime.entity.Activities activity) {
        this(
                activity.getId(),
                new ProjectsDTO(activity.getProjectId()),
                activity.getName(),
                activity.getDescription(),
                activity.getStartDate(),
                activity.getEndDate(),
                activity.getStatus(),
                new UsersDTO(activity.getIdResponsableUser()),
                activity.getCreationDate()
        );
    }
}
