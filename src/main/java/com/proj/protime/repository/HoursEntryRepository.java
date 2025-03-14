package com.proj.protime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proj.protime.entity.HoursEntry;

import java.util.List;


public interface HoursEntryRepository extends JpaRepository<HoursEntry, Integer>{
    List<HoursEntry> findByIdActivity_Id(Integer activityId);

    List<HoursEntry> findByIdUsers_Id(Integer userId);
}
