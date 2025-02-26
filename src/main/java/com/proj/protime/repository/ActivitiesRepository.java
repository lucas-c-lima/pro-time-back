package com.proj.protime.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.protime.entity.Activities;

import java.util.List;

public interface ActivitiesRepository extends JpaRepository<Activities, Integer>{

    List<Activities> findActivityByNameContaining(String value);
}
