package com.yq.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yq.po.User;
import com.yq.service.UserService;
/**
 * 用户控制层user
 *
 */
@Controller
@RequestMapping("user")
public class UserController {
	
	private UserService userService;
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	/**
	 * 跳转到后台登陆界面（login.jsp）
	 * @return
	 */
	@RequestMapping("tologin")
	public String toLoginView() {
		return "manage/login";
	}
	/**
	 *用户登陆
	 * @param userName
	 * @param userPassword
	 * @return
	 */
	@RequestMapping("ulogin")
	public String userLogin(@RequestParam String username,@RequestParam String password,HttpSession session) {
		User user=null;
		user=userService.login(username, password);
		if (user!=null) {
			session.setAttribute("user", user);
			return "redirect:../queryAllGoods.action";
		}
		return "redirect:tologin.action";
		
	}
	/**
	 * 后台退出，注销用户
	 * @param session
	 * @return
	 */
	@RequestMapping("exit")
	public String exit(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:../";
	}
	
}
