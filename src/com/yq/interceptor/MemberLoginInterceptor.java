package com.yq.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yq.po.Member;

/**
 * ��Ա��½������
 * 
 * @author Administrator
 *
 */

public class MemberLoginInterceptor implements HandlerInterceptor {
	/**
	 * handlerִ���������������
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * handlerִ��֮��ModelAndView����֮ǰ�����������
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * handlerִ��ǰ����
	 * 
	 * @return true ��������
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/*
		 * // TODO Auto-generated method stub String uri = request.getRequestURI();
		 * //˵��������Ƕ���ҳ�� if (uri.indexOf("myOrder")>=0) { HttpSession session=
		 * request.getSession(); Member member=(Member) session.getAttribute("member");
		 * if (member==null) { //������������������½����
		 * request.getRequestDispatcher("/login.jsp").forward(request, response); return
		 * false; } }
		 */
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		if (member == null) { // ������������������½����
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return false;
		}
		return true;
	}

}
