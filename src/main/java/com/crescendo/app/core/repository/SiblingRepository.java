package com.crescendo.app.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crescendo.app.core.components.Sibling;

@Repository
public interface SiblingRepository extends JpaRepository<Sibling, Integer>{

}
