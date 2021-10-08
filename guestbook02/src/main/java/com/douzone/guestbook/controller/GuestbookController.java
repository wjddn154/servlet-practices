package com.douzone.guestbook.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.guestbook.dao.GuestbookDAO;
import com.douzone.guestbook.vo.GuestbookVO;

public class GuestbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("link");
		if("join".equals(action)) {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String message = request.getParameter("message");

			Timestamp ts=new Timestamp(System.currentTimeMillis());  
		    Date date=new Date(ts.getTime());  
			
			GuestbookVO vo = new GuestbookVO();
			vo.setName(name);
			vo.setPassword(password);
			vo.setMessage(message);
			vo.setRegDate(date);
			
			new GuestbookDAO().insert(vo);
			
			response.sendRedirect("/guestbook02/gb");

		} else if ("delete".equals(action)) {
			String no = request.getParameter("no");
			String password = request.getParameter("password");
			
			new GuestbookDAO().delete(Long.parseLong(no), password);
			
			response.sendRedirect("/guestbook02/gb");
			
		} else if ("deleteform".equals(action)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp");
			rd.forward(request, response);
			
		} else {
			GuestbookDAO dao = new GuestbookDAO();
			List<GuestbookVO> list = dao.findAll();
			
			request.setAttribute("list", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(request, response);
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
