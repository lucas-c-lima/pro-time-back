package com.proj.protime.entity.dto.entries;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record HoursEntriesDTOPostPut(
        Integer idActivity,
        Integer idUser,
        String description,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime startDate,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime endDate

) {

}
