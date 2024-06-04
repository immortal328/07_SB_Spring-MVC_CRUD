package ap.immortal.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ap.immortal.model.Employee;
import ap.immortal.service.EmployeeService;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeMVCController {
	
	private final EmployeeService employeeService;
	
	@GetMapping("/hello")
	public String greeting() {
		return "Wellcome to Spring-Boot REST-API Employee's CRUD Operation Project...";
	}
	
	@GetMapping("/list")
	public String listEmployees(Model model) {
		
		List<Employee> employees = employeeService.findAllEmployees();
		model.addAttribute("employees", employees);
		return "employees/list-employees";	
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Employee employee = new Employee();
		theModel.addAttribute("employee", employee);
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.insert(employee);
		return "redirect:/employees/list";
	}

}
