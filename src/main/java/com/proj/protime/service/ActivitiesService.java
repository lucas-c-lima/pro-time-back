package com.proj.protime.service;

import com.proj.protime.entity.Projects;
import com.proj.protime.entity.Users;
import com.proj.protime.entity.dto.activities.ActivitiesDTO;
import com.proj.protime.entity.dto.activities.ActivitiesDTOPostPut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActivitiesService {

    List<ActivitiesDTO> getAllActivities();

    ActivitiesDTO findActivityById(Integer id);

    List<ActivitiesDTO> findActivityByName(String value);

    List<ActivitiesDTO> findActivitiesByUser(Users user);

    List<ActivitiesDTO> findActivitiesByProject(Projects projectId);

    ResponseEntity<ActivitiesDTO> createActivity(ActivitiesDTOPostPut activity);

    ActivitiesDTO updateActivity(Integer id, ActivitiesDTOPostPut activity);

    ResponseEntity<Void> deleteActivity(Integer id);
}
