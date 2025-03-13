package com.proj.protime.repository;

import com.proj.protime.entity.Projects;
import com.proj.protime.entity.Users;
import com.proj.protime.entity.dto.activities.ActivitiesDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.protime.entity.Activities;

import java.util.List;

public interface ActivitiesRepository extends JpaRepository<Activities, Integer>{

    List<Activities> findActivityByNameContaining(String value);

    List<Activities> findByIdResponsableUser(Users idResponsableUser);

    List<Activities> findByProjectId(Projects projectId);
}
