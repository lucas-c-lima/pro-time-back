package com.proj.protime.entity.dto.activities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proj.protime.entity.enums.ActivityStatus;

import java.time.LocalDateTime;

public record ActivitiesDTOPostPut(

        Integer projectId,
        String name,
        String description,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime startDate,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime endDate,
        ActivityStatus status,
        Integer idResponsableUser

) {
}
