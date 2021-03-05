package com.trms.services;

import java.util.Set;

import org.apache.log4j.Logger;

import com.trms.data.DAOFactory;
import com.trms.data.DepartmentsDAO;
import com.trms.data.EmployeeDAO;
import com.trms.data.EventTypeDAO;
import com.trms.data.GradingFormatDAO;
import com.trms.data.MessageDAO;
import com.trms.data.ReimbursementDAO;
import com.trms.models.Departments;
import com.trms.models.Employee;
import com.trms.models.EventType;
import com.trms.models.GradingFormat;
import com.trms.models.Message;
import com.trms.models.Reimbursement;

public class EmployeeServiceImpl implements EmployeeService {
	// Data Access Object
	private DepartmentsDAO deptDao;
	private EmployeeDAO empDao;
	private EventTypeDAO eventDao;
	private GradingFormatDAO gradeDao;
	private MessageDAO messDao;
	private ReimbursementDAO reimDao;

	private static Logger log = Logger.getLogger(EmployeeServiceImpl.class);

	public EmployeeServiceImpl() {
		deptDao = DAOFactory.getDepartmentsDAO();
		empDao = DAOFactory.getEmployeeDAO();
		eventDao = DAOFactory.getEventTypeDAO();
		gradeDao = DAOFactory.getGradingFormatDAO();
		messDao = DAOFactory.getMessageDAO();
		reimDao = DAOFactory.getReimbursementDAO();
	}

	@Override
	public Integer addEmployee(Employee e) {
		return empDao.add(e).getId();
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		return empDao.getById(id);
	}

	@Override
	public Employee getEmployeeByUsername(String username) {
		return empDao.getEmployeeByUsername(username);
	}

	@Override
	public void updateEmployee(Employee e) {
		empDao.update(e);

	}

	@Override
	public void deleteEmployee(Employee e) {
		empDao.delete(e);

	}

	@Override
	public Set<Employee> getAllEmployees() {
		return empDao.getAll();
	}

	@Override
	public Integer addDepartment(Departments e) {
		return deptDao.add(e).getId();
	}

	@Override
	public Departments getDepartmentsById(Integer id) {
		return deptDao.getById(id);
	}

	@Override
	public void updateDepartments(Departments e) {
		deptDao.update(e);

	}

	@Override
	public void deleteDepartments(Departments e) {
		deptDao.delete(e);

	}

	@Override
	public Set<Departments> getAllDepartments() {
		return deptDao.getAll();
	}

	@Override
	public Integer addEventType(EventType e) {
		return eventDao.add(e).getId();
	}

	@Override
	public EventType getEventTypeById(Integer id) {
		return eventDao.getById(id);
	}

	@Override
	public void updateEventType(EventType e) {
		eventDao.update(e);

	}

	@Override
	public void deleteEventType(EventType e) {
		eventDao.delete(e);

	}

	@Override
	public Set<EventType> getAllEventType() {
		return eventDao.getAll();
	}

	@Override
	public Integer addGradingFormat(GradingFormat e) {
		return gradeDao.add(e).getId();
	}

	@Override
	public GradingFormat getGradingFormatById(Integer id) {
		return gradeDao.getById(id);
	}

	@Override
	public void updateGradingFormat(GradingFormat e) {
		gradeDao.update(e);

	}

	@Override
	public void deleteGradingFormat(GradingFormat e) {
		gradeDao.delete(e);

	}

	@Override
	public Set<GradingFormat> getAllGradingFormat() {
		return gradeDao.getAll();
	}

	@Override
	public Integer addMessage(Message e) {
		return messDao.add(e).getId();
	}

	@Override
	public Message getMessageById(Integer id) {
		return messDao.getById(id);
	}

	@Override
	public void updateMessage(Message e) {
		messDao.update(e);

	}

	@Override
	public void deleteMessage(Message e) {
		messDao.delete(e);

	}

	@Override
	public Set<Message> getAllMessage() {
		return messDao.getAll();
	}

	@Override
	public Integer addReimbursement(Reimbursement e) {
		return reimDao.add(e).getId();
	}

	@Override
	public Reimbursement getReimbursementById(Integer id) {
		return reimDao.getById(id);
	}

	@Override
	public void updateReimbursement(Reimbursement e) {
		reimDao.update(e);

	}

	@Override
	public void deleteReimbursement(Reimbursement e) {
		reimDao.delete(e);

	}

	@Override
	public Set<Reimbursement> getAllReimbursement() {
		return reimDao.getAll();
	}
}
