package com.wonder.EmployeeService;

import com.wonder.EmployeeService.application.EmployeeApplicationService;
import com.wonder.EmployeeService.application.EmployeeController;
import com.wonder.EmployeeService.application.EmployeeDto;
import com.wonder.EmployeeService.domain.Employee;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class EmployeeControllerTest {
    @Autowired
    EmployeeController employeeController;

    @MockBean
    EmployeeApplicationService employeeApplicationService;

    @Test
    public void should_call_employee_application_service_when_get_an_employee(){
        when(employeeApplicationService.findByIds(101)).thenReturn(Arrays.asList(
                new EmployeeDto(){{
                    id = 101;
                    name = "Tom Cat";
                    age = 30;
                }}
        ));

        final EmployeeDto employeeDto = employeeController.get(101);

        assertEquals(101, employeeDto.id);
        assertEquals("Tom Cat", employeeDto.name);
        assertEquals(30, employeeDto.age);
        verify(employeeApplicationService, times(1)).findByIds(101);
    }

    @Test
    public void should_call_employee_application_service_when_batch_get_employees(){
        employeeController.batchGet(new long[]{101, 102});
       verify(employeeApplicationService, times(1)).findByIds(any());
    }
}
