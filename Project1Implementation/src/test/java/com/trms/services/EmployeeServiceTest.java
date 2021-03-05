package com.trms.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.trms.data.DepartmentsHibernate;
import com.trms.data.EmployeeHibernate;
import com.trms.data.EventTypeHibernate;
import com.trms.data.GradingFormatHibernate;
import com.trms.data.MessageHibernate;
import com.trms.data.ReimbursementHibernate;
import com.trms.models.Departments;
import com.trms.models.Employee;
import com.trms.models.EventType;
import com.trms.models.GradingFormat;
import com.trms.models.Message;
import com.trms.models.Reimbursement;

public class EmployeeServiceTest {
	public static EmployeeHibernate empDao;
	public static DepartmentsHibernate deptDao;
	public static EventTypeHibernate eventDao;
	public static GradingFormatHibernate gradeDao;
	public static MessageHibernate messDao;
	public static ReimbursementHibernate reimDao;

	@BeforeAll
	public static void setup() {
		empDao = new EmployeeHibernate();
		deptDao = new DepartmentsHibernate();
		eventDao = new EventTypeHibernate();
		gradeDao = new GradingFormatHibernate();
		messDao = new MessageHibernate();
		reimDao = new ReimbursementHibernate();
	}
	
	// Employee
	// CREATE
	@Test
	public void checkAddEmployee() {
		// Integer Employee e
		Employee e = new Employee();
		Departments d = new Departments();
		d.setId(2);
		d.setDepartmentName("human resources");
		e.setDepartment(d);
		e.setDirectSupervisor(e);
		e.getDirectSupervisor().setId(15);
		e.setFirstName("test");
		e.setLastName("test");
		e.setId(0);
		e.setPass("test");
		e.setReimbursementClaimed(0.0f);
		Random r = new Random();
		e.setUsername("test" + r.nextInt());
		e = empDao.add(e);
		assertNotEquals(0, e.getId());
	}

	// READ
	@Test
	public void checkGetEmployeeById() {
		// Employee Integer id
		Employee c = empDao.getById(15);
		// System.out.println(c);
		assertNotNull(c);
	}

	@Test
	public void checkGetEmployeeByUsername() {
		// Employee String username
		assertNotNull(empDao.getEmployeeByUsername("user"));
	}

	// UPDATE
	@Test
	public void checkUpdateEmployee() {
		// Employee e
		Employee e = empDao.getById(15);
		Random r = new Random();
		Float before = e.getReimbursementClaimed();
		Float randVal = r.nextFloat();
		e.setReimbursementClaimed(randVal);
		empDao.update(e);
		Employee c = empDao.getById(15);
		assertNotEquals(before, c.getReimbursementClaimed());
	}

	// DELETE
	@Test
	public void checkDeleteEmployee() {
		// Employee e
		Employee e = new Employee();
		Departments d = new Departments();
		d.setId(2);
		d.setDepartmentName("human resources");
		e.setDepartment(d);
		e.setDirectSupervisor(e);
		e.getDirectSupervisor().setId(15);
		e.setFirstName("test");
		e.setLastName("test");
		e.setId(0);
		e.setPass("test");
		e.setReimbursementClaimed(0.0f);
		Random r = new Random();
		e.setUsername("test" + r.nextInt());
		e = empDao.add(e);
		empDao.delete(e);
		assertNull(empDao.getById(e.getId()));
	}

	@Test
	public void checkGetAllEmployees() {
		// Set<Employee>
		assertNotNull(empDao.getAll());
	}

	// departments
	// CREATE
	@Test
	public void checkAddDepartment() {
		// Integer Departments e
		Departments d = new Departments();
		Employee e = new Employee();
		e.setId(15);
		d.setDepartmentName("test");
		d.setId(0);
		d = deptDao.add(d);
		assertNotEquals(0, d.getId());
	}

	// READ
	@Test
	public void checkGetDepartmentsById() {
		// Departments Integer id
		assertNotNull(deptDao.getById(2));
	}

	// UPDATE
	@Test
	public void checkUpdateDepartments() {
		// Departments e
		Departments d = deptDao.getById(6);
		Random r = new Random();
		String before = d.getDepartmentName();
		Integer i = r.nextInt();
		d.setDepartmentName("test" + i);
		deptDao.update(d);
		Departments c = deptDao.getById(6);
		assertNotEquals(before, c.getDepartmentName());
	}

	// DELETE
	@Test
	public void checkDeleteDepartments() {
		// Departments e
		Departments d = new Departments();
		Employee e = new Employee();
		e.setId(15);
		d.setDepartmentName("test");
		d.setId(0);
		d = deptDao.add(d);
		deptDao.delete(d);
		assertNull(deptDao.getById(d.getId()));
	}

	@Test
	public void checkGetAllDepartments() {
		// Set<Departments>
		assertNotNull(deptDao.getAll());
	}

	// eventtype
	// CREATE
	@Test
	public void checkAddEventType() {
		// Integer EventType e
		EventType e = new EventType();
		e.setFormat("test");
		e.setId(0);
		e = eventDao.add(e);
		assertNotEquals(0, e.getId());
	}

	// READ
	@Test
	public void checkGetEventTypeById() {
		// EventType Integer id
		assertNotNull(eventDao.getById(7));
	}

	// UPDATE
	@Test
	public void checkUpdateEventType() {
		// EventType e
		EventType e = eventDao.getById(7);
		Random r = new Random();
		String before = e.getFormat();
		Integer i = r.nextInt();
		e.setFormat("test" + i);
		eventDao.update(e);
		EventType c = eventDao.getById(7);
		assertNotEquals(before, c.getFormat());
	}

	// DELETE
	@Test
	public void checkDeleteEventType() {
		// EventType e
		EventType e = new EventType();
		e.setFormat("test");
		e.setId(0);
		e = eventDao.add(e);
		eventDao.delete(e);
		assertNull(eventDao.getById(e.getId()));
	}

	@Test
	public void checkGetAllEventType() {
		// Set<EventType>
		assertNotNull(eventDao.getAll());
	}

	// gradingformat
	// CREATE
	@Test
	public void checkAddGradingFormat() {
		// Integer GradingFormat e
		GradingFormat g = new GradingFormat();
		g.setFormat("test");
		g.setId(0);
		g = gradeDao.add(g);
		assertNotEquals(0, g.getId());
	}

	// READ
	@Test
	public void checkGetGradingFormatById() {
		// GradingFormat Integer id
		assertNotNull(gradeDao.getById(1));
	}

	// UPDATE
	@Test
	public void checkUpdateGradingFormat() {
		// GradingFormat e
		GradingFormat g = gradeDao.getById(3);
		Random r = new Random();
		String before = g.getFormat();
		Integer i = r.nextInt();
		g.setFormat("test" + i);
		gradeDao.update(g);
		GradingFormat c = gradeDao.getById(3);
		assertNotEquals(before, c.getFormat());
	}

	// DELETE
	@Test
	public void checkDeleteGradingFormat() {
		// GradingFormat e
		GradingFormat g = new GradingFormat();
		g.setFormat("test");
		g.setId(0);
		g = gradeDao.add(g);
		gradeDao.delete(g);
		assertNull(gradeDao.getById(g.getId()));
	}

	@Test
	public void checkGetAllGradingFormat() {
		// Set<GradingFormat>
		assertNotNull(gradeDao.getAll());
	}

	// message
	// CREATE
	@Test
	public void checkAddMessage() {
		// Integer Message e
		Message m = new Message();
		m.setContent("test");
		Employee e = new Employee();
		e.setId(15);
		m.setFrom(e);
		m.setId(0);
		m.setTo(e);
		m = messDao.add(m);
		assertNotEquals(0, m.getId());
	}

	// READ
	@Test
	public void checkGetMessageById() {
		// Message Integer id
		assertNotNull(messDao.getById(1));
	}

	// UPDATE
	@Test
	public void checkUpdateMessage() {
		// Message e
		Message m = messDao.getById(1);
		Random r = new Random();
		Integer i = r.nextInt();
		String before = m.getContent();
		m.setContent("test" + i);
		messDao.update(m);
		Message c = messDao.getById(1);
		assertNotEquals(before, c.getContent());
	}

	// DELETE
	@Test
	public void checkDeleteMessage() {
		// Message e
		Message m = new Message();
		m.setContent("test");
		Employee e = new Employee();
		e.setId(15);
		m.setFrom(e);
		m.setId(0);
		m.setTo(e);
		m = messDao.add(m);
		messDao.delete(m);
		assertNull(messDao.getById(m.getId()));

	}

	@Test
	public void checkGetAllMessage() {
		// Set<Message>
		assertNotNull(messDao.getAll());
	}

	// reinbursement
	// CREATE
	@Test
	public void checkAddReimbursement() {
		// Integer Reimbursement e
		Reimbursement r = new Reimbursement();
		r.setApproval(0);
		r.setAttatchments(null);
		Long l = 10101010L;
		r.setDate(new Timestamp(l));
		r.setDescription("test");
		Employee e = new Employee();
		e.setId(15);
		r.setEmployeeId(e);
		EventType et = new EventType();
		et.setId(6);
		et.setFormat("OTHER");
		r.setEvent(et);
		r.setEventCost(10f);
		GradingFormat g = new GradingFormat();
		g.setId(1);
		g.setFormat("GRADE");
		r.setFormat(g);
		r.setId(0);
		r.setJustification("test");
		r.setLocation("test");
		r = reimDao.add(r);
		assertNotEquals(0, r.getId());
	}

	// READ
	@Test
	public void checkGetReimbursementById() {
		// Reimbursement Integer id
		assertNotNull(reimDao.getById(1));
	}

	// READ
	@Test
	public void checkGetReimbursementByIdImage() {
		// Reimbursement Integer id
		Reimbursement r = reimDao.getById(56);
		byte[] b = r.getAttatchments();
		try {
			String fileName = "NewFileDownload";
			FileOutputStream fos = new FileOutputStream(new File(fileName));
			fos.write(b);
			fos.close();
			System.out.println("saved at: "+fileName);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// UPDATE
	@Test
	public void checkUpdateReimbursement() {
		// Reimbursement e
		Reimbursement r = reimDao.getById(1);
		Random ra = new Random();
		Integer i = ra.nextInt();
		String before = r.getJustification();
		r.setJustification("test" + i);
		reimDao.update(r);
		Reimbursement c = reimDao.getById(1);
		assertNotEquals(before, c.getJustification());
	}

	// DELETE
	@Test
	public void checkDeleteReimbursement() {
		// Reimbursement e
		Reimbursement r = new Reimbursement();
		r.setApproval(0);
		r.setAttatchments(null);
		Long l = 10101010L;
		r.setDate(new Timestamp(l));
		r.setDescription("test");
		Employee e = new Employee();
		e.setId(15);
		r.setEmployeeId(e);
		EventType et = new EventType();
		et.setId(6);
		et.setFormat("OTHER");
		r.setEvent(et);
		r.setEventCost(10f);
		GradingFormat g = new GradingFormat();
		g.setId(1);
		g.setFormat("GRADE");
		r.setFormat(g);
		r.setId(0);
		r.setJustification("test");
		r.setLocation("test");
		r = reimDao.add(r);
		reimDao.delete(r);
		assertNull(reimDao.getById(r.getId()));
	}

	@Test
	public void checkGetAllReimbursement() {
		// Set<Reimbursement>
		assertNotNull(reimDao.getAll());
	}

}
