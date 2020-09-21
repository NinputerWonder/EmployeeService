package com.wonder.EmployeeService.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeApplicationService employeeApplicationService;

    @PostMapping
    public List<EmployeeDto> batchGet(@RequestBody long[] ids) {
        return employeeApplicationService.findByIds(ids);
    }

    @GetMapping("/{id}")
    public EmployeeDto get(@PathVariable("id") long id) {
        return employeeApplicationService.findByIds(id).stream().findFirst().orElse(null);
    }
}
