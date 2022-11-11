package com.ch.nike.service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
public class SessionChk implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if (session == null || session.getAttribute("email") ==  null) { //로그인x - 이메일로그인창으로 
			response.sendRedirect("/member/emailLoginForm.do");
			return false; //원래 하려던 작업은 중단
		}
		return true; //로그인 되어있을때는, 원래작업 계속
	}
}