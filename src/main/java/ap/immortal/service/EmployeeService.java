package ap.immortal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ap.immortal.model.Employee;
import ap.immortal.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class EmployeeService {
	@Autowired
	private final EmployeeRepository employeeRepository;
	
	/**
	 * Method to find All Employee's 
	 * */
	public List<Employee> findAllEmployees() {
		return employeeRepository.findAll();
	}
	
	
	public Employee findEmployeeById(Integer employeeId) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
		if(!optionalEmployee.isPresent()) {
			//throw new EmployeeNotFoundException(String.format("Employee NOT Found for Employee Id : %d", employeeId));
		}
		return optionalEmployee.get();
	}
	
	public void insert(Employee employee) {
		employeeRepository.save(employee);
		log.info("Successfully inserted : {} in Database",employee);
	}
	
	public Employee updateEmployee(Integer employeeId) {
		Employee employee = findEmployeeById(employeeId);
		return employee;
	}
	
	public void deleteEmployee(Integer employeeId) {
		Employee employee = findEmployeeById(employeeId);
		employeeRepository.delete(employee);
		log.info("Successfully Deteted Employee : {} of Employee from Database",employee,employee.getId());

	}
	
	public void deleteAll() {
		employeeRepository.deleteAll();
		log.info("Successfully Deteted All Data from Database....");
	}

}
