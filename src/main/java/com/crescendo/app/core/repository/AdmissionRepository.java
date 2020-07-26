package com.crescendo.app.core.repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crescendo.app.core.components.admission.Admission;

@Repository
public interface AdmissionRepository extends JpaRepository<Admission, String> {

	default List<Admission> getAdmissionsBySearch(String searchQuery, Map<String, Object> args, Class<Admission> classA){
		
		List<Object> listOfObjects = ExecuteSql.executeNativeSqlString(searchQuery, args, classA);
		
		return listOfObjects.stream().map(Admission.class::cast)
			    .collect(Collectors.toList());
	}

}
