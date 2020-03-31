package com.yq.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yq.po.Favorits;
import com.yq.po.Goods;
import com.yq.po.Member;
import com.yq.service.MemberService;

/**
 * 会员Controller层
 *
 */
@Controller
public class MemberController {
	private MemberService memberService;
	private GoodsController goodsController;
	private FavoriteController favoriteController;

	@Autowired
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@Autowired
	public void setGoodsController(GoodsController goodsController) {
		this.goodsController = goodsController;
	}

	@Autowired
	public void setFavoriteController(FavoriteController favoriteController) {
		this.favoriteController = favoriteController;
	}
	/**
	 * 支付
	 * 验证密码
	 * @return
	 */
	@ResponseBody
	@RequestMapping("pwdtopay")
	public int PwdtoPay(String pwd,Double amount,HttpSession session) {
		Member member=(Member)session.getAttribute("member");
		String password=member.getMemberPassword();
		double myAmount=member.getMemberAmount();
		//密码正确
		if (password.equals(pwd)) {
			//余额充足
			if (myAmount >= amount) {
				member.setMemberAmount(member.getMemberAmount()-amount);
				int code=memberService.update(member);
				if (code>0) {
					session.removeAttribute("member");
					session.setAttribute("member", member);
					return code;
				}else {
					return code;
				}
				
			}else {
				return 0;
			}
		}else {
			return -1;
		}
	}

	/**
	 * 查询所有会员信息 并跳转到会员管理页面，MemberManage.jsp
	 * 
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping("qmembers")
	public String qMembers(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
		// 分页 页码，单页容量
		PageHelper.startPage(pn, 5);
		List<Member> members = memberService.queryAllMember();
		// 5表示连续可显示的页数
		PageInfo<Member> page = new PageInfo<Member>(members, 5);
		model.addAttribute("pageInfo", page);
		return "manage/MemberManage";
	}
	/**
	 * 通过name模糊查询会员
	 * @param memberName
	 * @param pn
	 * @return
	 */
	@RequestMapping("qmemberbyname")
	public ModelAndView queryMemberByName(String memberName,
			@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		ModelAndView mv = new ModelAndView("manage/MemberManage");
		PageHelper.startPage(pn, 5);
		List<Member> members = memberService.queryByName(memberName);
		// 5表示连续可显示的页数
		PageInfo<Member> page = new PageInfo<Member>(members, 5);
		mv.addObject("pageInfo", page);
		return mv;
	}

	/**
	 * 会员注册
	 * 
	 * @param member
	 * @return
	 */
	@RequestMapping("mregist")
	public String mRegist(Member member, String repassword) {
		if (member.getMemberPassword().equals(repassword) && !repassword.equals("")) {
			// 设置用户初始金额
			member.setMemberAmount(0.0);
			// 创建时间设定
			member.setCreateDate(new Date());
			// 会员状态设为“1”可用
			member.setMemberStatus("1");
			//设置初始金额为20000
			member.setMemberAmount(20000.00);
			int code = memberService.addMember(member);
			if (code <= 0) {
				// 注册失败
				return "register";
			} else {
				// 注册成功
				return "login";
			}
		}
		return "register";

	}

	/**
	 * 处理日期格式
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	/**
	 * 会员登陆
	 * 
	 * @param name
	 * @param password
	 * @return
	 */
	@RequestMapping("mlogin")
	public String mLogin(@RequestParam String name, @RequestParam String password, HttpSession session) {
		Member member = null;
		member = memberService.login(name, password);
		if (member != null) {
			// 登陆成功
			// 保存进域对象session
			//System.out.println(member);
			session.setAttribute("member", member);
			return "index";
		} else {
			// 登陆失败
			return "login";
		}

	}

	/**
	 * 注册页面使用，比较用户名，检测用户是否已经存在
	 * 
	 * @param name
	 */
	@ResponseBody // 使之返回json数据
	@RequestMapping("checkmname")
	public String checkmname(String name) {
		boolean code = memberService.queryByMemberName(name);
		String msg = "";
		if (code) {
			// 无此用户，可注册
			msg = "true";
		} else {
			// 不可注册
			msg = "false";
		}
		return msg;
	}

	/**
	 * 会员注销登陆
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("mexit")
	public String exitMember(HttpSession session) {
		session.removeAttribute("member");
		return "index";
	}

	/**
	 * 跳转个人中心
	 * 
	 * @param memberID
	 * @return
	 */
	@RequestMapping("myindex")
	public ModelAndView myIndex(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session) {
		ModelAndView mv=new ModelAndView("/person/index");
		Member member=(Member) session.getAttribute("member");
		List<Favorits> favorits= favoriteController.getFavoritsBymemberID(member.getMemberID());
		//收藏的商品
		//每页显示数量 4
		PageHelper.startPage(pn, 4);
		List<Goods> goods = new ArrayList<Goods>();
		for (Favorits favorit : favorits) {
			Goods tempGoods=goodsController.getGoodsByGoodsID(favorit.getGoodsID());
			goods.add(tempGoods);
		}
		PageInfo<Goods> page = new PageInfo<Goods>(goods, 5);
		//查询最新商品
		//最新商品显示的数量
		int count=2;
		List<Goods> newGoods=goodsController.getNewGoods(count);
		
		mv.addObject("favorit", page);
		mv.addObject("newGoods", newGoods);
		return mv;
	}

	/**
	 * 跳转个人信息修改页面 会员名，邮箱可修改
	 * 
	 * @return
	 */
	@RequestMapping("tomyinfo")
	public String toMyInfo() {

		return "/person/information";
	}

	/**
	 * 修改会员信息（该方法只可修改邮箱）
	 * 
	 * @param member
	 * @return
	 */
	@RequestMapping("updateminfo")
	public String updateMemberInfo(Member member,HttpSession session) {
		int mid=((Member)session.getAttribute("member")).getMemberID();
		member.setMemberID(mid);
		int code = memberService.update(member);
		
		String memberName = (String)((Member)session.getAttribute("member")).getMemberName();
		String memberPassword=(String)((Member)session.getAttribute("member")).getMemberPassword();
		if (code > 0) {
			// 成功
			member= memberService.login(memberName, memberPassword);
			session.removeAttribute("member");
			session.setAttribute("member", member);
			return "/person/information";
		} else {
			// 失败
			return "/person/information";
		}
	}

	/**
	 * 跳转安全设置页面 可修改密码
	 * 
	 * @return
	 */
	@RequestMapping("tosafety")
	public String toSafety() {

		return "/person/safety";
	}
	/**
	 * 跳转修改密码页面
	 * @return
	 */
	@RequestMapping("topwd")
	public String toPwd() {
		return "/person/pwd";
	}
	/**
	 * 验证原密码是否正确
	 * @param name
	 * @param pwd
	 * @return
	 */
	@ResponseBody
	@RequestMapping("comparepwd")
	public int comparePwd( String name ,String pwd) {
		Member member=memberService.login(name, pwd);
		int code=0;
		if (member != null) {
			//正确
			code=1;
		}else {
			//错误
			code=0;
		}
		return code;
	}
	/**
	 * 修改会员密码
	 * @param id
	 * @param newpwd
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("updatmpwd")
	public int updatMemberpwd( Integer id,String newpwd,HttpSession session) {
		Member member=(Member) session.getAttribute("member");
		member.setMemberPassword(newpwd);
		member.setMemberID(id);
		int code = memberService.update(member);
		if (code>0) {
			member=memberService.login(member.getMemberName(), member.getMemberPassword());
			session.removeAttribute("member");
			session.setAttribute("member", member);
			
			return code;
		}else {
			return code;
		}
		
	}
	
	/**
	 * 修改会员状态
	 * 
	 * @param name
	 * @param status
	 * @return
	 */
	@ResponseBody
	@RequestMapping("updatemstatus")
	public String updateMemberStatus(Member member) {
		int code = memberService.update(member);
		if (code > 0) {
			return member.getMemberStatus();
		} else {
			return "error";
		}

	}

}
