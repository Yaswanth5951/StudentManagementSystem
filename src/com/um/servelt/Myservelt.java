package com.um.servelt;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.um.dao.UserDao;
import com.um.model.User;

@WebServlet("/")
public class Myservelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String path=request.getServletPath();
		switch(path)
		{
		case"/add":newUser(request,response);
		break;
		case"/insert":insertUser(request,response);
		break;
		case"/delete":deleteUser(request,response);
		break;
		case"/edit":selectUserById(request,response);
		break;
		default:list(request,response);
		break;
		
		}
	}

	

	private void selectUserById(HttpServletRequest request, HttpServletResponse response) {
		int id=Integer.parseInt(request.getParameter("id"));
	User u=	UserDao.selectUserById(id);
	request.setAttribute("us", u);
		RequestDispatcher rd=request.getRequestDispatcher("edit.jsp");
		try {
			rd.forward(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
		int id=Integer.parseInt(request.getParameter("id"));
		UserDao.delete(id);
		try {
			response.sendRedirect("list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void insertUser(HttpServletRequest request, HttpServletResponse response) {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String city=request.getParameter("city");
		User u=new User(name,email,city);
		UserDao.insert(u);
		try {
			response.sendRedirect("list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void newUser(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher rd=request.getRequestDispatcher("UserForm.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void list(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<User> a1=UserDao.display();
		request.setAttribute("display", a1);
	RequestDispatcher rd=request.getRequestDispatcher("UserList.jsp");
	try {
		rd.forward(request, response);
	} catch (ServletException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			doGet(request, response);
	}

}
