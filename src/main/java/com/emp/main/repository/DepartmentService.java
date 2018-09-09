package com.emp.main.repository;

import java.net.HttpURLConnection;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {
	
	Map<String, Object> getDepartmentDetails(Long id);
	
	

}
