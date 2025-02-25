package com.proj.protime.entity.dto.projects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proj.protime.entity.enums.ProjectPriority;
import com.proj.protime.entity.enums.ProjectStatus;

import java.time.LocalDateTime;

public record ProjectDTOPostPut(
        String name,
        String description,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime startDate,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime endDate,
        ProjectStatus status,
        Integer idResponsableUser,
        ProjectPriority priority
) {
}
