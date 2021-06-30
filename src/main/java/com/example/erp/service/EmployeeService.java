package com.example.erp.service;

import com.example.erp.bean.Employee;
import com.example.erp.dao.EmployeeDao;
import com.example.erp.dao.implementation.EmployeeDaoImpl;

public class EmployeeService {
    EmployeeDao employeeDao = new EmployeeDaoImpl();
    public Employee employeeVerify(Employee employee){
        return employeeDao.employeeVerify(employee);
    }
}
