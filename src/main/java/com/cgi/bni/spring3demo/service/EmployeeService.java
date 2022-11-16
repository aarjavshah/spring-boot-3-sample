package com.cgi.bni.spring3demo.service;

import com.cgi.bni.spring3demo.exception.EmployeeNotFoundException;
import com.cgi.bni.spring3demo.model.Employee;
import com.cgi.bni.spring3demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployee(Long employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(EmployeeNotFoundException::new);
    }

}
