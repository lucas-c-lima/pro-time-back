	package com.proj.protime.controller;
	
	import java.util.List;

	import com.proj.protime.entity.dto.entries.HoursEntriesDTO;
	import com.proj.protime.entity.dto.entries.HoursEntriesDTOPostPut;
	import jakarta.validation.Valid;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;

	import com.proj.protime.entity.HoursEntry;
	import com.proj.protime.service.HoursEntryService;
	
	@RestController
	@RequestMapping("/entries")
	public class HoursEntryController {
	
		@Autowired
		private HoursEntryService hoursEntryService;
		
		@GetMapping
		public ResponseEntity<List<HoursEntriesDTO>> getAllEntries(){
			List<HoursEntriesDTO> hoursEntry = hoursEntryService.getAllEntries();
			return ResponseEntity.ok().body(hoursEntry);
		}

		@GetMapping("/{id}")
		public ResponseEntity<HoursEntriesDTO> findEntryById(@PathVariable Integer id){
			HoursEntriesDTO hoursEntry = hoursEntryService.findEntryById(id);
			return ResponseEntity.ok().body(hoursEntry);
		}

		@GetMapping("/activities/{activityId}")
		public ResponseEntity<List<HoursEntriesDTO>> findEntryByActivity(@PathVariable Integer activityId){
			List<HoursEntriesDTO> hoursEntries = hoursEntryService.findEntryByActivity(activityId);
			return ResponseEntity.ok().body(hoursEntries);
		}

		// TODO FAZER BUSCAR POR OBJETOS ESPECIFICOS

		@PostMapping
		public ResponseEntity<HoursEntriesDTO> createEntry(@Valid @RequestBody HoursEntriesDTOPostPut hoursEntry){
			return hoursEntryService.createEntry(hoursEntry);
		}

		@PutMapping("/{id}")
		public ResponseEntity<HoursEntriesDTO> updateEntry(@PathVariable Integer id, @Valid @RequestBody HoursEntriesDTOPostPut hoursEntry){
			return ResponseEntity.ok(hoursEntryService.updateEntry(id, hoursEntry));
		}

		//TODO implementar soft delete!!!!
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> deleteEntry(@PathVariable Integer id){
			hoursEntryService.deleteEntry(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
	}
