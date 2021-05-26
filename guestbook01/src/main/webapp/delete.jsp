<%@page import="com.douzone.guestbook.dao.GuestBookDao"%>
<%@page import="com.douzone.guestbook.vo.GuestBookVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String strNo = request.getParameter("no");
	Long no = Long.parseLong(strNo);
	String password = request.getParameter("password");
	
	GuestBookVo vo = new GuestBookVo();
	vo.setNo(no);
	vo.setPassword(password);
	
	new GuestBookDao().delete(vo);
	
	response.sendRedirect(request.getContextPath()); // request, response, session은 servlet 내장객체
%>