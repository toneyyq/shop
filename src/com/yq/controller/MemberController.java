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
 * ��ԱController��
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
	 * ֧��
	 * ��֤����
	 * @return
	 */
	@ResponseBody
	@RequestMapping("pwdtopay")
	public int PwdtoPay(String pwd,Double amount,HttpSession session) {
		Member member=(Member)session.getAttribute("member");
		String password=member.getMemberPassword();
		double myAmount=member.getMemberAmount();
		//������ȷ
		if (password.equals(pwd)) {
			//������
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
	 * ��ѯ���л�Ա��Ϣ ����ת����Ա����ҳ�棬MemberManage.jsp
	 * 
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping("qmembers")
	public String qMembers(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
		// ��ҳ ҳ�룬��ҳ����
		PageHelper.startPage(pn, 5);
		List<Member> members = memberService.queryAllMember();
		// 5��ʾ��������ʾ��ҳ��
		PageInfo<Member> page = new PageInfo<Member>(members, 5);
		model.addAttribute("pageInfo", page);
		return "manage/MemberManage";
	}
	/**
	 * ͨ��nameģ����ѯ��Ա
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
		// 5��ʾ��������ʾ��ҳ��
		PageInfo<Member> page = new PageInfo<Member>(members, 5);
		mv.addObject("pageInfo", page);
		return mv;
	}

	/**
	 * ��Աע��
	 * 
	 * @param member
	 * @return
	 */
	@RequestMapping("mregist")
	public String mRegist(Member member, String repassword) {
		if (member.getMemberPassword().equals(repassword) && !repassword.equals("")) {
			// �����û���ʼ���
			member.setMemberAmount(0.0);
			// ����ʱ���趨
			member.setCreateDate(new Date());
			// ��Ա״̬��Ϊ��1������
			member.setMemberStatus("1");
			//���ó�ʼ���Ϊ20000
			member.setMemberAmount(20000.00);
			int code = memberService.addMember(member);
			if (code <= 0) {
				// ע��ʧ��
				return "register";
			} else {
				// ע��ɹ�
				return "login";
			}
		}
		return "register";

	}

	/**
	 * �������ڸ�ʽ
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	/**
	 * ��Ա��½
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
			// ��½�ɹ�
			// ����������session
			//System.out.println(member);
			session.setAttribute("member", member);
			return "index";
		} else {
			// ��½ʧ��
			return "login";
		}

	}

	/**
	 * ע��ҳ��ʹ�ã��Ƚ��û���������û��Ƿ��Ѿ�����
	 * 
	 * @param name
	 */
	@ResponseBody // ʹ֮����json����
	@RequestMapping("checkmname")
	public String checkmname(String name) {
		boolean code = memberService.queryByMemberName(name);
		String msg = "";
		if (code) {
			// �޴��û�����ע��
			msg = "true";
		} else {
			// ����ע��
			msg = "false";
		}
		return msg;
	}

	/**
	 * ��Աע����½
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
	 * ��ת��������
	 * 
	 * @param memberID
	 * @return
	 */
	@RequestMapping("myindex")
	public ModelAndView myIndex(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session) {
		ModelAndView mv=new ModelAndView("/person/index");
		Member member=(Member) session.getAttribute("member");
		List<Favorits> favorits= favoriteController.getFavoritsBymemberID(member.getMemberID());
		//�ղص���Ʒ
		//ÿҳ��ʾ���� 4
		PageHelper.startPage(pn, 4);
		List<Goods> goods = new ArrayList<Goods>();
		for (Favorits favorit : favorits) {
			Goods tempGoods=goodsController.getGoodsByGoodsID(favorit.getGoodsID());
			goods.add(tempGoods);
		}
		PageInfo<Goods> page = new PageInfo<Goods>(goods, 5);
		//��ѯ������Ʒ
		//������Ʒ��ʾ������
		int count=2;
		List<Goods> newGoods=goodsController.getNewGoods(count);
		
		mv.addObject("favorit", page);
		mv.addObject("newGoods", newGoods);
		return mv;
	}

	/**
	 * ��ת������Ϣ�޸�ҳ�� ��Ա����������޸�
	 * 
	 * @return
	 */
	@RequestMapping("tomyinfo")
	public String toMyInfo() {

		return "/person/information";
	}

	/**
	 * �޸Ļ�Ա��Ϣ���÷���ֻ���޸����䣩
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
			// �ɹ�
			member= memberService.login(memberName, memberPassword);
			session.removeAttribute("member");
			session.setAttribute("member", member);
			return "/person/information";
		} else {
			// ʧ��
			return "/person/information";
		}
	}

	/**
	 * ��ת��ȫ����ҳ�� ���޸�����
	 * 
	 * @return
	 */
	@RequestMapping("tosafety")
	public String toSafety() {

		return "/person/safety";
	}
	/**
	 * ��ת�޸�����ҳ��
	 * @return
	 */
	@RequestMapping("topwd")
	public String toPwd() {
		return "/person/pwd";
	}
	/**
	 * ��֤ԭ�����Ƿ���ȷ
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
			//��ȷ
			code=1;
		}else {
			//����
			code=0;
		}
		return code;
	}
	/**
	 * �޸Ļ�Ա����
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
	 * �޸Ļ�Ա״̬
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
