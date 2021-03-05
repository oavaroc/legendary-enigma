package com.trms.data;

import com.trms.models.Employee;

public interface EmployeeDAO extends GenericDAO<Employee> {
	public Employee getEmployeeByUsername(String u);
}
