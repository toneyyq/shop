package com.yq.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yq.po.Member;

/**
 * 会员登陆拦截器
 * 
 * @author Administrator
 *
 */

public class MemberLoginInterceptor implements HandlerInterceptor {
	/**
	 * handler执行完后调用这个方法
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * handler执行之后，ModelAndView返回之前调用这个方法
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * handler执行前调用
	 * 
	 * @return true 代表不拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/*
		 * // TODO Auto-generated method stub String uri = request.getRequestURI();
		 * //说明请求的是订单页面 if (uri.indexOf("myOrder")>=0) { HttpSession session=
		 * request.getSession(); Member member=(Member) session.getAttribute("member");
		 * if (member==null) { //不符合条件，跳到登陆界面
		 * request.getRequestDispatcher("/login.jsp").forward(request, response); return
		 * false; } }
		 */
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		if (member == null) { // 不符合条件，跳到登陆界面
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return false;
		}
		return true;
	}

}
