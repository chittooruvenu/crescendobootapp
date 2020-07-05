package com.crescendo.app.core.repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.crescendo.app.core.components.FollowUp;

@Repository
public interface FollowUpRepository extends JpaRepository<FollowUp, Integer>{
	
	@Query(value="SELECT * FROM Followup  WHERE ENQUIRY_ID = :enquiryId", nativeQuery = true)
	public List<FollowUp> findFollowUpsByEnquiryId(@Param("enquiryId")String enquiryId);

	@Query(value="SELECT * FROM Followup  WHERE ENQUIRY_ID = :enquiryId AND FOLLOWUP_ID = :followUpId", nativeQuery = true)
	public FollowUp findFollowUpsByEnquiryIdAndFollowUpId(String enquiryId, String followUpId);

	default List<FollowUp> getFollowUpsBySearch(String searchQuery, Map<String, Object> args, Class classF){
		List<Object> listOfObjects = ExecuteSql.executeNativeSqlString(searchQuery, args, classF);
		
		return listOfObjects.stream().map(FollowUp.class::cast)
			    .collect(Collectors.toList());
		
	}
}
