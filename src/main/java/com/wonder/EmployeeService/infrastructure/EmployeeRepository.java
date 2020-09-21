package com.wonder.EmployeeService.infrastructure;

import com.wonder.EmployeeService.domain.Employee;
import com.wonder.EmployeeService.domain.IEmployeeRepository;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Component
public class EmployeeRepository implements IEmployeeRepository {
    final List<Employee> dbData = Arrays.asList(
            new Employee("Tom", "Cat", 30),
            new Employee("Jerry", "Rat", 27)
    );

    @Override
    public List<Employee> findByIds(long... employeeIds) {
        final List<Employee> employees = new LinkedList<>();

        for (int i = 0; i < employeeIds.length; i++) {
            Employee employee = null;
            if(i % 2 ==  0){
                employee = new Employee("Tom", "Cat", 30);
            } else {
                employee = new Employee("Jerry", "Rat", 27);
            }

            employee.setId(employeeIds[i]);
            employees.add(employee);
        }

        return employees;
    }
}
