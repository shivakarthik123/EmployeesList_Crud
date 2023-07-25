package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	// load employee data
	private EmployeeService employeeservice;
	public EmployeeController(EmployeeService theEmployeeService){
		employeeservice=theEmployeeService;
	}

	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		List<Employee> theEmployees=employeeservice.findAll();
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		Employee theEmployee =new Employee();
		theModel.addAttribute("employee",theEmployee);
		return "employees/employee-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel){
		//get employee from the service
		Employee theEmployee=employeeservice.findById(theId);
		//set it to the model
		theModel.addAttribute("employee",theEmployee);
		//sent it to the form
		return "employees/employee-form";

	}
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
		employeeservice.save(theEmployee);
		return "redirect:/employees/list";
	}
	@GetMapping("delete")
	public String delete(@RequestParam("employeeId") int theId){
		//delete the employee
		employeeservice.deleteById(theId);
		//redirect list
		return "redirect:/employees/list";
	}
}









