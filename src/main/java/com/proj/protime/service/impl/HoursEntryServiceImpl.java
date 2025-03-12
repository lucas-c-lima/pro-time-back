package com.proj.protime.service.impl;

import java.util.List;

import com.proj.protime.entity.Activities;
import com.proj.protime.entity.Users;
import com.proj.protime.entity.dto.entries.HoursEntriesDTO;
import com.proj.protime.entity.dto.entries.HoursEntriesDTOPostPut;
import com.proj.protime.entity.mapper.EntryMapper;
import com.proj.protime.repository.ActivitiesRepository;
import com.proj.protime.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.proj.protime.entity.HoursEntry;
import com.proj.protime.repository.HoursEntryRepository;
import com.proj.protime.service.HoursEntryService;

@Service
public class HoursEntryServiceImpl implements HoursEntryService {

	@Autowired
	private HoursEntryRepository hoursEntryRepository;
	@Autowired
	private ActivitiesRepository activitiesRepository;
	@Autowired
	private UsersRepository userRepository;
	
	@Override
	public List<HoursEntriesDTO> getAllEntries(){
		return hoursEntryRepository.findAll().stream().map(HoursEntriesDTO::new).toList();
	}

	@Override
	public HoursEntriesDTO findEntryById(Integer id) {
		return new HoursEntriesDTO(
			hoursEntryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Entry not found"))
		);
	}

	@Override
	public List<HoursEntriesDTO> findEntryByActivity(Integer activityId) {;
		List<HoursEntry> entries = hoursEntryRepository.findByIdActivity_Id(activityId);
		return entries.stream().map(HoursEntriesDTO::new).toList();
	}

	@Override
	public ResponseEntity<HoursEntriesDTO> createEntry(
			HoursEntriesDTOPostPut hoursEntry) {
		Activities idActivity = activitiesRepository.findById(hoursEntry.idActivity())
				.orElseThrow(() -> new RuntimeException("Activity not found"));
		Users idUser = userRepository.findById(hoursEntry.idUser())
				.orElseThrow(() -> new RuntimeException("User not found"));

		HoursEntry newEntry = new HoursEntry(
			idActivity,
			idUser,
			hoursEntry.description(),
			hoursEntry.startDate(),
			hoursEntry.endDate()
		);

		HoursEntry saved = hoursEntryRepository.save(newEntry);
		return ResponseEntity.ok(new HoursEntriesDTO(saved));
	}

	@Override
	public HoursEntriesDTO updateEntry(
			Integer id, HoursEntriesDTOPostPut hoursEntry) {

		HoursEntry current = hoursEntryRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Entry not found"));
		Activities idActivity = activitiesRepository.findById(hoursEntry.idActivity())
				.orElseThrow(() -> new RuntimeException("Activity not found"));
		Users idUser = userRepository.findById(hoursEntry.idUser())
				.orElseThrow(() -> new RuntimeException("User not found"));

		HoursEntry updated = new HoursEntry(
			idActivity,
			idUser,
			hoursEntry.description(),
			hoursEntry.startDate(),
			hoursEntry.endDate()
		);
		updated.setRegisterDate(current.getRegisterDate());

		EntryMapper.INSTANCE.updateHoursEntry(current, updated);

		HoursEntry saved = hoursEntryRepository.save(current);
		return EntryMapper.INSTANCE.toHoursEntryDTOPut(saved);
	}

	@Override
	public ResponseEntity<Void> deleteEntry(Integer id) {
		return hoursEntryRepository.findById(id)
			.map(hoursFound -> {
				hoursEntryRepository.deleteById(id);
				return ResponseEntity.noContent().<Void>build();
		}).orElseThrow(() -> new RuntimeException("Entry not found"));
	}




}
