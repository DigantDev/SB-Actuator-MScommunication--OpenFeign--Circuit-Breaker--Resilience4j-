package com.ps.empservice.serviceimpl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ps.digant.Deptartmentservice.dto.DepartmentDto;

@FeignClient(url="http://localhost:8081/",value="Deptartment-service")
//@FeignClient(name="Deptartment-service")
public interface APIClient {
	 @GetMapping("api/departments/{department-code}")
	    DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);

}
