package com.proj.protime.entity.dto.entries;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proj.protime.entity.dto.activities.ActivitiesDTO;
import com.proj.protime.entity.dto.users.UsersDTO;

import java.time.LocalDateTime;

public record HoursEntriesDTO(
        Integer id,
        ActivitiesDTO idActivities,
        UsersDTO idUsers,
        String description,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime startDate,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime endDate,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime registerDate
) {
    public HoursEntriesDTO(com.proj.protime.entity.HoursEntry hoursEntry) {
        this(
                hoursEntry.getId(),
                new ActivitiesDTO(hoursEntry.getIdActivity()),
                new UsersDTO(hoursEntry.getIdUsers()),
                hoursEntry.getDescription(),
                hoursEntry.getStartDate(),
                hoursEntry.getEndDate(),
                hoursEntry.getRegisterDate()
        );
    }
}