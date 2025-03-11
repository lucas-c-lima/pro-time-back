package com.proj.protime.service.impl;

import com.proj.protime.entity.Activities;
import com.proj.protime.entity.Projects;
import com.proj.protime.entity.Users;
import com.proj.protime.entity.dto.activities.ActivitiesDTO;
import com.proj.protime.entity.dto.activities.ActivitiesDTOPostPut;
import com.proj.protime.entity.mapper.ActivityMapper;
import com.proj.protime.repository.ActivitiesRepository;
import com.proj.protime.repository.ProjectsRepository;
import com.proj.protime.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.proj.protime.service.ActivitiesService;

import java.util.List;

@Service
public class ActivitiesServiceImpl implements ActivitiesService {

    @Autowired
    private ActivitiesRepository activitiesRepository;

    @Autowired
    private ProjectsRepository projectsRepository;

    @Autowired
    private UsersRepository userRepository;

    @Override
    public List<ActivitiesDTO> getAllActivities() {
        return activitiesRepository.findAll().stream().map(ActivitiesDTO::new).toList();
    }

    @Override
    public ActivitiesDTO findActivityById(Integer id) {
        return new ActivitiesDTO(
            activitiesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Activity not found"))
        );
    }

    @Override
    public List<ActivitiesDTO> findActivityByName(String value) {
        return activitiesRepository.findActivityByNameContaining(value).stream().map(ActivitiesDTO::new).toList();
    }

    @Override
    public List<ActivitiesDTO> findActivitiesByUser(Users user) {
        return activitiesRepository.findByIdResponsableUser(user).stream().map(ActivitiesDTO::new).toList();
    }

    @Override
    public ResponseEntity<ActivitiesDTO> createActivity(
            ActivitiesDTOPostPut activity) {
        Projects idProject = projectsRepository.findById(activity.idProjects())
                .orElseThrow(() -> new RuntimeException("Project not found"));
        Users responsableUser = userRepository.findById(activity.idResponsableUser())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Activities newActivity = new Activities(
            activity.name(),
            activity.description(),
            activity.startDate(),
            activity.endDate(),
            activity.status(),
            idProject,
            responsableUser
        );

        Activities saved = activitiesRepository.save(newActivity);
        return ResponseEntity.ok(new ActivitiesDTO(saved));
    }

    @Override
    public ActivitiesDTO updateActivity(
            Integer id, ActivitiesDTOPostPut activity
    ) {
        Activities current = activitiesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Activity not found"));
        Projects idProject = projectsRepository.findById(activity.idProjects())
                .orElseThrow(() -> new RuntimeException("Project not found"));
        Users responsableUser = userRepository.findById(activity.idResponsableUser())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Activities updated = new Activities(
            activity.name(),
            activity.description(),
            activity.startDate(),
            activity.endDate(),
            activity.status(),
            idProject,
            responsableUser
        );
        updated.setCreationDate(current.getCreationDate());

        ActivityMapper.INSTANCE.updateActivity(current, updated);

        Activities saved = activitiesRepository.save(current);
        return ActivityMapper.INSTANCE.toActivityDTOPut(saved);
    }

    @Override
    public ResponseEntity<Void> deleteActivity(Integer id) {
        return activitiesRepository.findById(id)
            .map(activityFound -> {
                activitiesRepository.deleteById(id);
                return ResponseEntity.noContent().<Void>build();
            }).orElseThrow(() -> new RuntimeException("Activity not found"));
    }
}
