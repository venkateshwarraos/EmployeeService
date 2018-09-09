package com.emp.main.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.emp.main.repository.DepartmentService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	
	private static final Logger log = LoggerFactory.getLogger(DepartmentServiceImpl.class);

	
	private static final String serviceUrl="http://localhost:8091/departmentdetails/department/";

	
	public Map<String, Object> getDepartmentDetails(Long id) {
		
		BufferedReader bufferedReader = null;
		String departData = null;
		StringBuffer content = null;
		Map<String, Object> dataMap = null;
		List<Object> dataList = null;
		HttpURLConnection connection = null;
		try {
			dataMap =  getConnection(id);
			
				
				
			
		} catch(Exception exception) {
			
			log.error("exception occured while processing service",exception);
			
		}
		
			
			 return dataMap;
			
			
					
		
		
	}

	

	
	private Map<String,Object>  getConnection(Long id) {
		
		RestTemplate restTemplate = null;
		ResponseEntity<Map> responseEntity = null;
		List<Object> dataList = null;
		Map<String,Object> dataMap = null;
		
		try {
			
			restTemplate = new RestTemplate();
			responseEntity = restTemplate.getForEntity(DepartmentServiceImpl.serviceUrl.concat(id.toString()), Map.class);
			if(responseEntity.getStatusCodeValue()!=200)  {
				throw new Exception();
			} else {
				dataMap = responseEntity.getBody();
	    }
			
		} catch (Exception exception) {
			log.error("exception occured while processing service",exception);
			
		}		
		
		return dataMap;
	}

}
