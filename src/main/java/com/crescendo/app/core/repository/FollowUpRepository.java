package com.crescendo.app.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crescendo.app.core.components.FollowUp;

@Repository
public interface FollowUpRepository extends JpaRepository<FollowUp, Integer>{

}
