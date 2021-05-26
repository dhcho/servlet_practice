package com.douzone.guestbook.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.guestbook.dao.GuestBookDao;
import com.douzone.guestbook.vo.GuestBookVo;

public class GuestbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post 방식으로 전달받는 파라미터 값의 엔코딩 처리
		request.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("a");
		
		if("deleteform".equals(action)) {
			// view로 포워딩
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp");
			rd.forward(request, response);
		} else if("add".equals(action)) {
			//1. 요청처리
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String message = request.getParameter("message");
			
			GuestBookVo vo = new GuestBookVo();
			vo.setName(name);
			vo.setPassword(password);
			vo.setMessage(message);
			
			new GuestBookDao().insert(vo);
			
			// 2. redirect 응답 
			response.sendRedirect(request.getContextPath() + "/gb");
		} else if("delete".equals(action)) {
			//1. 요청처리
			String strNo = request.getParameter("no");
			Long no = Long.parseLong(strNo);
			String password = request.getParameter("password");
			
			GuestBookVo vo = new GuestBookVo();
			vo.setNo(no);
			vo.setPassword(password);
			
			new GuestBookDao().delete(vo);
			
			// 2. redirect 응답 
			response.sendRedirect(request.getContextPath() + "/gb");
		} else {
			/* default request(action) */
			
			//1. 요청처리
			List<GuestBookVo> list = new GuestBookDao().findAll();
			
			//2. request범위에 데이터(객체) 저장
			request.setAttribute("list", list);
			
			//3. view로 포워딩
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
