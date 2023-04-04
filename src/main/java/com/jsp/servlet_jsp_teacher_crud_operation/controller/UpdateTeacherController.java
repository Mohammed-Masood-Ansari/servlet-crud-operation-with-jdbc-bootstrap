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

@WebServlet(value = "/updatedata")
public class UpdateTeacherController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));

		String name = req.getParameter("name");

		String email = req.getParameter("email");
		
		long phone = Integer.parseInt(req.getParameter("phone"));
		
		Teacher teacher = new Teacher();
		
		teacher.setName(name);
		teacher.setEmail(email);
		teacher.setPhone(phone);
		
		TeacherService service = new TeacherService();
		
		service.updateTeacher(teacher, id);
		
		RequestDispatcher dispatcher =req.getRequestDispatcher("display.jsp");
		dispatcher.forward(req, resp);
		
	}
}
