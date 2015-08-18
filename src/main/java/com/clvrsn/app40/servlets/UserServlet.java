package com.clvrsn.app40.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.clvrsn.app40.dao.UserDAO;
import com.clvrsn.app40.entities.User;

@Component
@WebServlet(value = "/user")
public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = -36138938542088505L;

	@Autowired
	private UserDAO userDao;

	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		PrintWriter out = response.getWriter();
		if (id == null) {
			out.println("Por favor, informe um Id (Exemplo: /app40/user?id=1)");
			return;
		}
		User u = userDao.findById(Integer.valueOf(id));
		out.println("Ola: " + u.getName());

	}

}
