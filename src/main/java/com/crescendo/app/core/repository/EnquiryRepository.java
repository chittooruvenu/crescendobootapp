package com.crescendo.app.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crescendo.app.core.components.Enquiry;

@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, String>{
	
}
