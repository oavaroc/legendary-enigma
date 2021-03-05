package com.trms.delegates;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trms.models.Employee;
import com.trms.models.Message;
import com.trms.services.EmployeeService;
import com.trms.services.EmployeeServiceImpl;

public class EmployeeDelegate implements FrontControllerDelegate {
	private EmployeeService cs = new EmployeeServiceImpl();
	private ObjectMapper om = new ObjectMapper();

	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = (String) req.getAttribute("path"); // represents the identifier endpoint
		
		if (path == null || path.equals("")) { //default path ... could get all cats or specific one if you indicate in the code below
			switch (req.getMethod()) {
				case "POST":
					// add a cat
					Employee c = (Employee) om.readValue(req.getInputStream(), Employee.class); //create a cat based on parameters of request
					//c.setId(cs.addCat(c)); //only thing need cuz new cat has no id
					c = new Employee();
					c.setId(1);
					c.setFirstName("test");
					c.setLastName("test");
					resp.getWriter().write(om.writeValueAsString(c));
					resp.setStatus(HttpServletResponse.SC_CREATED);
					break;
				case "GET":
					resp.getWriter().write(
							om.writeValueAsString(new Employee()));
					break;
				default:
					resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
					break;
			}
		} else if (path.contains("adopt")) {
			if ("POST".equals(req.getMethod())) {
				Employee c = (Employee) om.readValue(req.getInputStream(), Employee.class);
				//Person p = (Person) req.getSession().getAttribute("person");
//				try {
//					cs.adoptCat(p, c);
//				} catch (CatAlreadyAdoptedException e) {
//					resp.sendError(HttpServletResponse.SC_CONFLICT, "Cat already adopted");
//				}
				c = new Employee();
				c.setId(1);
				c.setFirstName("test");
				c.setLastName("test");
				resp.getWriter().write(om.writeValueAsString(c));
				resp.setStatus(HttpServletResponse.SC_ACCEPTED);
			} else {
				resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			}
		} else {
			int messId = Integer.valueOf(path);
			Employee c = null;
			switch (req.getMethod()) {
				case "GET":
					c = cs.getEmployeeById(messId);
					if (c != null) 
						resp.getWriter().write(om.writeValueAsString(c));
					else
						resp.sendError(404, "Employee not found.");
					break;
				default:
					resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
					break;
			}			
		}
	}
	
//	private boolean isEmployee(Person p) {
//		if (p != null && p.getRole().getName().equals("Employee"))
//			return true;
//		else
//			return false;
//	}

}
