package com.proj.protime.entity.mapper;

import com.proj.protime.entity.HoursEntry;
import com.proj.protime.entity.dto.entries.HoursEntriesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EntryMapper {

    HoursEntriesDTO toHoursEntryDTOPut(HoursEntry hoursEntry);

    EntryMapper INSTANCE = Mappers.getMapper(EntryMapper.class);

    @Mapping(target = "id", ignore = true)
    void updateHoursEntry(
            @MappingTarget HoursEntry hoursEntry,
            HoursEntry hoursEntryPut
    );

}
