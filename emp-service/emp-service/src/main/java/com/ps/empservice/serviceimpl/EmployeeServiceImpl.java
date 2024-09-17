package com.ps.empservice.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.empservice.dto.APIResponseDto;
import com.ps.empservice.dto.EmployeeDto;
import com.ps.empservice.entity.Employee;
import com.ps.empservice.repository.EmployeeRepository;
import com.ps.empservice.service.EmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import ps.digant.Deptartmentservice.dto.DepartmentDto;



@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	 private EmployeeRepository employeeRepository;
	 @Autowired
	 private APIClient apiClient;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		
		  Employee employee = new Employee(employeeDto.getId(),employeeDto.getFirstName(), employeeDto.getLastName(),
				  employeeDto.getEmail(),employeeDto.getDepartmentCode(),
				  employeeDto.getOrganizationCode());
		  
		  Employee saveDEmployee = employeeRepository.save(employee);
		  EmployeeDto savedEmployeeDto= new EmployeeDto(saveDEmployee.getId(), saveDEmployee.getFirstName(),
				  saveDEmployee.getLastName(), saveDEmployee.getEmail(), saveDEmployee.getDepartmentCode(), saveDEmployee.getOrganizationCode());
		
		return savedEmployeeDto;
	}

	@Override
	//@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
	public APIResponseDto getEmployeeById(Long employeeId) {
		 Employee employee = employeeRepository.findById(employeeId).get();
		 DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());
		 
		    EmployeeDto employeeDto =new EmployeeDto(employee.getId(), employee.getFirstName(), 
		    		employee.getLastName(), employee.getEmail(), employee.getDepartmentCode(),employee.getOrganizationCode());
		    
		    APIResponseDto apiResponseDto = new APIResponseDto();
	        apiResponseDto.setEmployee(employeeDto);
	        apiResponseDto.setDepartment(departmentDto);
	        
		return apiResponseDto;
	}
	
//	public APIResponseDto getDefaultDepartment(Long employeeId, Exception e) {
//		 Employee employee = employeeRepository.findById(employeeId).get();
//		 
//		 //DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());
//		 
//		 DepartmentDto departmentDto =new DepartmentDto();
//		  //departmentDto.setId(1l);
//		  departmentDto.setDepartmentName("Some error");
//		  departmentDto.setDepartmentDescription("Plz wait sometime");
//		  departmentDto.setDepartmentCode("Nodept");
//		  
//		 
//		    EmployeeDto employeeDto =new EmployeeDto(employee.getId(), employee.getFirstName(), 
//		    		employee.getLastName(), employee.getEmail(), employee.getDepartmentCode(),employee.getOrganizationCode());
//		    
//		    APIResponseDto apiResponseDto = new APIResponseDto();
//	        apiResponseDto.setEmployee(employeeDto);
//	        apiResponseDto.setDepartment(departmentDto);
//	        
//		return apiResponseDto;
//	}

}
