package com.aslam.www.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.aslam.www.exception.ResourceNotFoundException;
import com.aslam.www.model.Employee;
import com.aslam.www.repository.EmployeeRepository;
@Service
public class EmployeeService
{
	@Autowired
	EmployeeRepository er;
	public List<Employee> getAllEmployees()
	{
		return er.findAll();
	}
	public Employee createEmployee(Employee employee)
	{
		return er.save(employee);
	}
	public Employee getEmployeeById(Long id)
	{
		return er.findById(id).orElseThrow(()->new ResourceNotFoundException("Id Not Found"));
	}
	public ResponseEntity<Employee> updateEmployee(Long id,Employee employee)
	{
		Employee emp=er.findById(id).orElseThrow(()->new ResourceNotFoundException("Id Not found"));
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setEmail(employee.getEmail());
		Employee update=er.save(emp);
		return ResponseEntity.ok(update);
	}
	public ResponseEntity<HttpStatus> deleteEmployee(long id)
	{
		Employee employee=er.findById(id).orElseThrow(()->new ResourceNotFoundException("Id Not Found"));
		er.delete(employee);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
