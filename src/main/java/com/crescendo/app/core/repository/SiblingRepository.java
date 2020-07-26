package com.crescendo.app.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.crescendo.app.core.components.Sibling;

@Repository
public interface SiblingRepository extends JpaRepository<Sibling, Integer>{

	@Query(value="SELECT * FROM Siblings  WHERE ENQUIRY_ID = :enquiryId", nativeQuery = true)
	List<Sibling> findSiblingsByEnquiryId(@Param("enquiryId")String enquiryId);
}
