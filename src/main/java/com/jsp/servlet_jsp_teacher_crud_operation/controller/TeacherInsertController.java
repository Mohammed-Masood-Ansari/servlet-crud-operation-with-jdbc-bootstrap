package com.jsp.servlet_jsp_teacher_crud_operation.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.servlet_jsp_teacher_crud_operation.dto.Teacher;
import com.jsp.servlet_jsp_teacher_crud_operation.service.TeacherService;

@WebServlet(value = "/register")
public class TeacherInsertController extends HttpServlet {

	@Override
	public void destroy() {
		System.out.println("this is destroy method");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("this is init method");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("this is service method");
		
		int id = Integer.parseInt(req.getParameter("id"));

		String name = req.getParameter("name");

		String email = req.getParameter("email");
		
		long phone = Integer.parseInt(req.getParameter("phone"));
		
		Teacher teacher = new Teacher();
		
		teacher.setId(id);
		teacher.setName(name);
		teacher.setEmail(email);
		teacher.setPhone(phone);
		
		TeacherService service = new TeacherService();
		
		service.saveTeacher(teacher);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("register.jsp");
		dispatcher.forward(req, resp);
		
	}
}
