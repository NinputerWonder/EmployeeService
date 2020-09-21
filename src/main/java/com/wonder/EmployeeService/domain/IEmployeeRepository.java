package com.wonder.EmployeeService.domain;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> findByIds(long... employeeIds);
}
