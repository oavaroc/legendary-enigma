package com.trms.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trms.models.Employee;
import com.trms.models.Message;
import com.trms.services.EmployeeService;
import com.trms.services.EmployeeServiceImpl;
/*
 * Endpoints:
 *  /message - (POST) send a message
 *  /message - (GET) get all messages
 * 	/message/:id - (GET) get message by id
 */
public class MessageDelegate implements FrontControllerDelegate  {
	private EmployeeService cs = new EmployeeServiceImpl();
	private ObjectMapper om = new ObjectMapper();

	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = (String) req.getAttribute("path"); // represents the identifier endpoint
		
		if (path == null || path.equals("")) { //default path ... could get all cats or specific one if you indicate in the code below
			switch (req.getMethod()) {
				case "POST":
					// add a cat
					//System.out.println(req.getInputStream().read());
					Message c = (Message) om.readValue(req.getInputStream(), Message.class); //create a cat based on parameters of request
					//c.setId(cs.addCat(c)); //only thing need cuz new cat has no id
					c.setId(cs.addMessage(c)); //only thing need cuz new cat has no id
					resp.getWriter().write(om.writeValueAsString(c));
					resp.setStatus(HttpServletResponse.SC_CREATED);
					break;
				case "GET":
					resp.getWriter().write(
							om.writeValueAsString(cs.getAllMessage()));
					break;
				default:
					resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
					break;
			}
		} else {
			int messId = Integer.valueOf(path);
			Message c = null;
			switch (req.getMethod()) {
				case "GET":
					c = cs.getMessageById(messId);
					if (c != null) 
						resp.getWriter().write(om.writeValueAsString(c));
					else
						resp.sendError(404, "Cat not found.");
					break;
				default:
					resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
					break;
			}			
		}
	}

}
