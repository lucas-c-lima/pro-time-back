package com.proj.protime.controller;

import com.proj.protime.entity.dto.activities.ActivitiesDTO;
import com.proj.protime.entity.dto.activities.ActivitiesDTOPostPut;
import com.proj.protime.service.ActivitiesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivitiesController {

	@Autowired
    private ActivitiesService activitiesService;

    @GetMapping
    public ResponseEntity<List<ActivitiesDTO>> getAllActivities(){
        List<ActivitiesDTO> activities = activitiesService.getAllActivities();
        return ResponseEntity.ok().body(activities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivitiesDTO> findActivityById(@PathVariable Integer id){
        ActivitiesDTO activity = activitiesService.findActivityById(id);
        return ResponseEntity.ok().body(activity);
    }

    @GetMapping("/name")
    public ResponseEntity<List<ActivitiesDTO>> findActivityByName(@RequestParam String value){
        List<ActivitiesDTO> activity = activitiesService.findActivityByName(value);
        return ResponseEntity.ok().body(activity);
    }

    @PostMapping
    public ResponseEntity<ActivitiesDTO> createActivity(@Valid @RequestBody ActivitiesDTOPostPut activity){
        return activitiesService.createActivity(activity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActivitiesDTO> updateActivity(@PathVariable Integer id, @Valid @RequestBody ActivitiesDTOPostPut activity){
        return ResponseEntity.ok(activitiesService.updateActivity(id, activity));
    }

    //TODO implementar soft delete!!!!
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivity(@PathVariable Integer id){
        activitiesService.deleteActivity(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
