package com.study.employee.Resource;

import com.study.employee.Service.ServiceEmployee;
import com.study.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {

    @Autowired
    private final ServiceEmployee serviceEmployee;

    public EmployeeResource(ServiceEmployee serviceEmployee) {
        this.serviceEmployee = serviceEmployee;
    }


    @GetMapping("/allemployees")
    public ResponseEntity <List<Employee>> getAllEmployees(){

        List<Employee> employees = serviceEmployee.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity <Employee> getEmployeesById(@PathVariable("id") Long id){

       Employee employee = serviceEmployee.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee= serviceEmployee.addEmployee(employee);
        return new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee newEmployee= serviceEmployee.updateEmployee(employee);
        return new ResponseEntity<>(newEmployee,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Long id){
       serviceEmployee.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
