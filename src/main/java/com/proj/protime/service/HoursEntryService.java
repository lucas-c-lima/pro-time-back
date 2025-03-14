package com.proj.protime.service;

import java.util.List;

import com.proj.protime.entity.HoursEntry;
import com.proj.protime.entity.dto.entries.HoursEntriesDTO;
import com.proj.protime.entity.dto.entries.HoursEntriesDTOPostPut;
import org.springframework.http.ResponseEntity;

public interface HoursEntryService {

	List<HoursEntriesDTO> getAllEntries();

	HoursEntriesDTO findEntryById(Integer id);

	ResponseEntity<HoursEntriesDTO> createEntry(HoursEntriesDTOPostPut hoursEntry);

	HoursEntriesDTO updateEntry(Integer id, HoursEntriesDTOPostPut hoursEntry);

	ResponseEntity<Void> deleteEntry(Integer id);

	List<HoursEntriesDTO> findEntryByActivity(Integer activityId);

	List<HoursEntriesDTO> findEntriesByUsers(Integer userId);
}
