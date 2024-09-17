package com.ps.empservice.service;

import com.ps.empservice.dto.APIResponseDto;
import com.ps.empservice.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);

}
