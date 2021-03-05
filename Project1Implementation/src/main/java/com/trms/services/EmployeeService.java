package com.trms.services;

import java.util.Set;

import com.trms.models.Departments;
import com.trms.models.Employee;
import com.trms.models.EventType;
import com.trms.models.GradingFormat;
import com.trms.models.Message;
import com.trms.models.Reimbursement;

public interface EmployeeService {
	//employee
	//CREATE
	public Integer addEmployee(Employee e);
	//READ
	public Employee getEmployeeById(Integer id);
	public Employee getEmployeeByUsername(String username);
	//UPDATE
	public void updateEmployee(Employee e);
	//DELETE
	public void deleteEmployee(Employee e);
	
	public Set<Employee> getAllEmployees();


	//departments
	//CREATE
	public Integer addDepartment(Departments e);
	//READ
	public Departments getDepartmentsById(Integer id);
	//UPDATE
	public void updateDepartments(Departments e);
	//DELETE
	public void deleteDepartments(Departments e);
	
	public Set<Departments> getAllDepartments();
	
	//eventtype
	//CREATE
	public Integer addEventType(EventType e);
	//READ
	public EventType getEventTypeById(Integer id);
	//UPDATE
	public void updateEventType(EventType e);
	//DELETE
	public void deleteEventType(EventType e);
	
	public Set<EventType> getAllEventType();
	
	
	//gradingformat
	//CREATE
	public Integer addGradingFormat(GradingFormat e);
	//READ
	public GradingFormat getGradingFormatById(Integer id);
	//UPDATE
	public void updateGradingFormat(GradingFormat e);
	//DELETE
	public void deleteGradingFormat(GradingFormat e);
	
	public Set<GradingFormat> getAllGradingFormat();
	
	
	//message
	//CREATE
	public Integer addMessage(Message e);
	//READ
	public Message getMessageById(Integer id);
	//UPDATE
	public void updateMessage(Message e);
	//DELETE
	public void deleteMessage(Message e);
	
	public Set<Message> getAllMessage();
	
	
	//reinbursement
	//CREATE
	public Integer addReimbursement(Reimbursement e);
	//READ
	public Reimbursement getReimbursementById(Integer id);
	//UPDATE
	public void updateReimbursement(Reimbursement e);
	//DELETE
	public void deleteReimbursement(Reimbursement e);
	
	public Set<Reimbursement> getAllReimbursement();
}
