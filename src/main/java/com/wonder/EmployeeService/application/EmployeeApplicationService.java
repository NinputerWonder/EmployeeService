package com.wonder.EmployeeService.application;

import com.wonder.EmployeeService.domain.Employee;
import com.wonder.EmployeeService.domain.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeApplicationService {

    @Autowired
    IEmployeeRepository employeeRepository;

    public List<EmployeeDto> findByIds(long... employeeIds) {
        final List<Employee> employees = employeeRepository.findByIds(employeeIds);
        return employees.stream().map(e -> toDto(e)).collect(Collectors.toList());
    }

    EmployeeDto toDto(Employee employee){
        return new EmployeeDto(){{
            id = employee.getId();
            name = employee.getFirstName() + " " + employee.getLastName();
            age = employee.getAge();
        }};
    }
}
