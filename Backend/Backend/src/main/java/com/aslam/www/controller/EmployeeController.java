package com.aslam.www.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aslam.www.model.Employee;
import com.aslam.www.service.EmployeeService;
@CrossOrigin(origins= "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController 
{
	@Autowired
	EmployeeService es;
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		return es.getAllEmployees();
	}
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee)
	{
		return es.createEmployee(employee);
	}
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable Long id)
	{
		return es.getEmployeeById(id);
	}
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employee)
	{
		return es.updateEmployee(id,employee);
	}
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id)
	{
		return es.deleteEmployee(id);
	}
}
