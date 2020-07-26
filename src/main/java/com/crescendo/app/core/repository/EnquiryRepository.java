package com.crescendo.app.core.repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crescendo.app.core.components.Enquiry;

@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, String>{
	
	
	default List<Enquiry> getEnqueriesBySearch(String searchQuery, Map<String, Object> queryArgs, Class classE) {
		
		List<Object> listOfObjects = ExecuteSql.executeNativeSqlString(searchQuery, queryArgs, classE);
				
		return listOfObjects.stream().map(Enquiry.class::cast)
			    .collect(Collectors.toList());
		
	}
	
}

