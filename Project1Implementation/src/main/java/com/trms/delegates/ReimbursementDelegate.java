package com.trms.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trms.models.Employee;
import com.trms.models.Message;
import com.trms.models.Reimbursement;
import com.trms.services.EmployeeService;
import com.trms.services.EmployeeServiceImpl;

/*
 * Endpoints:
 *  /reimburse - (POST) create new reimburese
 * 	/reimburse/:id - (GET) get reimburese by id
 *            - (PUT) update a reimburese
 */
public class ReimbursementDelegate implements FrontControllerDelegate {
	private EmployeeService cs = new EmployeeServiceImpl();
	private ObjectMapper om = new ObjectMapper();

	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = (String) req.getAttribute("path"); // represents the identifier endpoint

		if (path == null || path.equals("")) { // default path ... could get all cats or specific one if you indicate in
												// the code below
			switch (req.getMethod()) {
			case "POST":
				// add a cat
				Reimbursement c = (Reimbursement) om.readValue(req.getInputStream(), Reimbursement.class); // create a
																											// cat based
																											// on
																											// parameters
																											// of
																											// request
				// c.setId(cs.addCat(c)); //only thing need cuz new cat has no id
				c.setId(cs.addReimbursement(c));
				resp.getWriter().write(om.writeValueAsString(c));
				resp.setStatus(HttpServletResponse.SC_CREATED);
				break;
			case "GET":
				resp.getWriter().write(om.writeValueAsString(cs.getAllReimbursement()));
				break;
			default:
				resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
				break;
			}
		} else {
			int messId = Integer.valueOf(path);
			Reimbursement c = null;
			switch (req.getMethod()) {
			case "GET":
				c = cs.getReimbursementById(messId);
				if (c != null)
					resp.getWriter().write(om.writeValueAsString(c));
				else
					resp.sendError(404, "Cat not found.");
				break;
			case "PUT":
				c = om.readValue(req.getInputStream(), Reimbursement.class);
				cs.updateReimbursement(c);
				resp.getWriter().write(om.writeValueAsString(c));
				break;
			default:
				resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
				break;
			}
		}
	}

}
