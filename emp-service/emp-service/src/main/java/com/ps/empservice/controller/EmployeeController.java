package com.ps.empservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ps.empservice.dto.APIResponseDto;
import com.ps.empservice.dto.EmployeeDto;
import com.ps.empservice.service.EmployeeService;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
	
		@Autowired
	   private EmployeeService employeeService;
		
		 // Save Employee REST API
	    @PostMapping("/saveemp")
	    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
	        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
	        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	    }
	    
	    // Get Employee REST API
	    @GetMapping("getemp/{id}")
	    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Long employeeId){
	        APIResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);
	        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
	    }

}