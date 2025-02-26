package com.proj.protime.entity.mapper;

import com.proj.protime.entity.Activities;
import com.proj.protime.entity.dto.activities.ActivitiesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ActivityMapper {

    ActivitiesDTO toActivityDTOPut(Activities activity);

    ActivityMapper INSTANCE = Mappers.getMapper(ActivityMapper.class);

    @Mapping(target = "id", ignore = true)
    void updateActivity(
            @MappingTarget Activities activity,
            Activities activityPut
    );
}
