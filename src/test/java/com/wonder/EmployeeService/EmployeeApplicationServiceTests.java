package com.wonder.EmployeeService;

import com.wonder.EmployeeService.application.EmployeeApplicationService;
import com.wonder.EmployeeService.application.EmployeeDto;
import com.wonder.EmployeeService.domain.Employee;
import com.wonder.EmployeeService.domain.IEmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class EmployeeApplicationServiceTests {

	@Autowired
	EmployeeApplicationService employeeApplicationService;

	@MockBean
	IEmployeeRepository employeeRepository;

	@Test
	void should_return_employees_when_batch_get_by_ids() {

		long[] employeeIds = new long[]{21, 22};

		when(employeeRepository.findByIds(employeeIds)).thenReturn(Arrays.asList(
				new Employee("Tom", "Cat", 30){{
					setId(21);
				}},
				new Employee("Jerry", "Rat", 27){{
					setId(22);
				}}
		));

		List<EmployeeDto> actualEmployees = employeeApplicationService.findByIds(employeeIds);

		EmployeeDto employeeDto = actualEmployees.stream().filter(e -> e.id == 21).findFirst().orElse(null);
		assertEquals("Tom Cat", employeeDto.name);
		assertEquals(30, employeeDto.age);

		employeeDto = actualEmployees.stream().filter(e -> e.id == 22).findFirst().orElse(null);
		assertEquals("Jerry Rat", employeeDto.name);
		assertEquals(27, employeeDto.age);

		verify(employeeRepository, times(1)).findByIds(any(long[].class));
	}

}
