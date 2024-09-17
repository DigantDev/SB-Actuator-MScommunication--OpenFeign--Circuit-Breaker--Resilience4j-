package com.ps.empservice.dto;

import ps.digant.Deptartmentservice.dto.DepartmentDto;

public class APIResponseDto {
	
	private EmployeeDto employee;
    private DepartmentDto department;
    
    
    
	public APIResponseDto() {
		super();
	}
	
	public APIResponseDto(EmployeeDto employee, DepartmentDto department) {
		super();
		this.employee = employee;
		this.department = department;
	}
	public EmployeeDto getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeDto employee) {
		this.employee = employee;
	}
	public DepartmentDto getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentDto department) {
		this.department = department;
	}
    
	
    

}
