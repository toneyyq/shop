package com.yq.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import com.yq.po.Goods;
import com.yq.po.Member;
import com.yq.po.MemberAddressBook;
import com.yq.po.OrderInfo;
import com.yq.service.CartGoodsService;
import com.yq.service.GoodService;
import com.yq.service.MemberAddressBookService;
import com.yq.service.OrderInfoService;

/**
 * �������Ʋ�
 * 
 * @author Administrator
 *
 */
@Controller
public class OrderInfoController {
	private OrderInfoService orderInfoService;
	private MemberAddressBookService memberAddressBookService;
	private GoodService goodService;
	private CartGoodsService cartGoodsService;
	
	@Autowired
	public void setCartGoodsService(CartGoodsService cartGoodsService) {
		this.cartGoodsService = cartGoodsService;
	}

	@Autowired
	public void setOrderInfoService(OrderInfoService orderInfoService) {
		this.orderInfoService = orderInfoService;
	}

	@Autowired
	public void setMemberAddressBookService(MemberAddressBookService memberAddressBookService) {
		this.memberAddressBookService = memberAddressBookService;
	}

	@Autowired
	public void setGoodService(GoodService goodService) {
		this.goodService = goodService;
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
	 * ɾ������
	 * 
	 * @param orderID
	 * @return
	 */
	@RequestMapping("delorder")
	public String delOrder(int orderID) {
		orderInfoService.delOrderInfo(orderID);
		return "redirect:myorders.do";
	}

	/**
	 * �޸Ķ�������ת֧��������ʾ����
	 * 
	 * @param orderInfo
	 * @return
	 */
	@RequestMapping("updateorder")
	public ModelAndView updateOrder(OrderInfo orderInfo) {
		ModelAndView mv = new ModelAndView("success");
		if ("".equals(orderInfo.getOrderRemark())) {
			orderInfo.setOrderRemark(null);
		}
		orderInfo.setCreateDate(new Date());
		orderInfoService.updateOrderInfo(orderInfo);
		MemberAddressBook addressBook = memberAddressBookService.queryMemberAddressBookByID(orderInfo.getId());
		OrderInfo dataOrderInfo = orderInfoService.queryOrderInfoByOrderID(orderInfo.getOrderID());
		// ��Ʒ�������
		if ("1".equals(dataOrderInfo.getOrderStatus())) {
			Goods goods = goodService.queryGoodsByGoodsID(dataOrderInfo.getGoodsID());
			goods.setGoodsNumber(goods.getGoodsNumber() - dataOrderInfo.getGoodsCount());
			goodService.updateGoods(goods);
		}

		mv.addObject("addressBook", addressBook);
		mv.addObject("goodsID", dataOrderInfo.getGoodsID());
		mv.addObject("order", dataOrderInfo);
		return mv;
	}

	/**
	 * �޸Ķ�����ַ
	 * 
	 * @param orderID
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("setorderaddressid")
	public int setOrderAddressId(int orderID, int id) {
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setOrderID(orderID);
		orderInfo.setId(id);
		int code = orderInfoService.updateOrderInfo(orderInfo);
		return code;
	}

	/**
	 * ��ת����ȷ�ϸ���ҳ��pay.jsp
	 * 
	 * @param orderID
	 * @param session
	 * @return
	 */
	@RequestMapping("topay")
	public ModelAndView toPay(Integer orderID, HttpSession session) {
		ModelAndView mv = new ModelAndView("/person/pay");
		// 1.��ȡmember��Ϣ
		int mid = ((Member) session.getAttribute("member")).getMemberID();
		// 2.��ȡ��ַ����
		List<MemberAddressBook> addressBooks = memberAddressBookService.queryMemberAddressBooksByMemberID(mid);
		MemberAddressBook defaultAddressBook = new MemberAddressBook();
		for (MemberAddressBook memberAddressBook : addressBooks) {
			if ("1".equals(memberAddressBook.getTatus())) {
				defaultAddressBook = memberAddressBook;
			}
		}
		addressBooks.remove(defaultAddressBook);
		// 3.��������
		OrderInfo orderInfo = orderInfoService.queryOrderInfoByOrderID(orderID);
		// 5.��Ʒ��Ϣ
		Goods goods = goodService.queryGoodsByGoodsID(orderInfo.getGoodsID());

		// Ĭ�ϵ�ַ��Ϣ
		mv.addObject("defaddress", defaultAddressBook);
		// ��Ա���е�ַ����Ĭ�ϵ�ַ��
		mv.addObject("addressBooks", addressBooks);
		// ��Ʒ��Ϣ
		mv.addObject("goods", goods);
		// ������Ϣ
		mv.addObject("orderInfo", orderInfo);
		return mv;
	}

	/**
	 * ��������
	 * 
	 * @param orderInfo
	 * @param session
	 * @return
	 */
	@RequestMapping("toaddorder")
	public String toAddOrder(OrderInfo orderInfo, HttpSession session) {
		// 1.��ȡmember��Ϣ
		int mid = ((Member) session.getAttribute("member")).getMemberID();
		// 2.��ȡ��ַid(Ĭ�ϵ�ַ��
		List<MemberAddressBook> addressBooks = memberAddressBookService.queryMemberAddressBooksByMemberID(mid);
		MemberAddressBook defaultAddressBook = null;
		for (MemberAddressBook memberAddressBook : addressBooks) {
			if ("1".equals(memberAddressBook.getTatus())) {
				defaultAddressBook = memberAddressBook;
			}
		}
		// ��תȥ����Ĭ�ϵ�ַ
		if (defaultAddressBook == null) {
			return "redirect:myaddress.do";
		} else {
			orderInfo.setId(defaultAddressBook.getId());
			// 3.���ʽ����
			orderInfo.setOrderPay("���");
			// 4.������ʽ����
			orderInfo.setOrderCarry("��ͨ");
			// 5.��Ʒ��Ϣ
			Goods goods = goodService.queryGoodsByGoodsID(orderInfo.getGoodsID());

			// 6.������Ϣ����
			// δ����״̬
			if (orderInfo.getGoodsCount() == null) {
				orderInfo.setGoodsCount(1);
			}
			// �ܶ�
			orderInfo.setOrderAmount(orderInfo.getGoodsCount() * goods.getGoodsMemberPrice());
			// δ����
			orderInfo.setOrderStatus("-1");
			// memberID
			orderInfo.setMemberID(mid);
			// ����ʱ��
			orderInfo.setCreateDate(new Date());
			// 7.�����ݿ����Ĭ�϶���
			orderInfoService.addOrderInfo(orderInfo);
			//ɾ�����ﳵ
			cartGoodsService.deleteCartGoodsBymemberIDAndGoodsID(mid, orderInfo.getGoodsID());

			// 8.��ȡ�����ӵĶ�����
			int orderID = orderInfoService.getNewDataId(mid);

			// ��ת֧��ҳ��
			return "redirect:topay.do?orderID=" + orderID;
		}

	}

	/**
	 * ��ѯ���ж�����¼
	 * 
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping("qorders")
	public String qOrderInfos(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
		// ��ҳ ҳ�룬��ҳ����
		PageHelper.startPage(pn, 5);
		List<OrderInfo> orderInfos = orderInfoService.queryAllOrderInfo();

		// 5��ʾ��������ʾ��ҳ��
		PageInfo<OrderInfo> page = new PageInfo<OrderInfo>(orderInfos, 5);

		model.addAttribute("pageInfo", page);

		return "manage/OrderManage";
	}

	/**
	 * ��ѯ���� ͨ��id��״̬
	 * 
	 * @param id     ������
	 * @param status ״̬
	 * @param pn     ҳ��
	 * @return
	 */
	@RequestMapping("qoderinfobyidandtatus")
	public ModelAndView queryOrderInfoByIdAndStatus(int id, String status,
			@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		ModelAndView mv = new ModelAndView("manage/OrderManage");
		if ("null".equals(status)) {
			status = null;
		}
		;
		// ��ҳ ҳ�룬��ҳ����
		PageHelper.startPage(pn, 5);
		List<OrderInfo> orderInfos = orderInfoService.queryOrderInfoByIdAndStatus(id, status);
		// 5��ʾ��������ʾ��ҳ��
		PageInfo<OrderInfo> page = new PageInfo<OrderInfo>(orderInfos, 5);
		mv.addObject("pageInfo", page);
		return mv;
	}

	/**
	 * �ҵĶ���ҳ��
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("myorders")
	public ModelAndView myOrders(HttpSession session) {
		ModelAndView mv = new ModelAndView("person/order");
		Member member = (Member) session.getAttribute("member");
		int mid = member.getMemberID();
		List<OrderInfo> orderInfos = orderInfoService.queryOrderInfoByMemberID(mid);
		Map<OrderInfo, Goods> orderMap = new LinkedHashMap<OrderInfo, Goods>();
		for (OrderInfo orderInfo : orderInfos) {
			Goods goods = goodService.queryGoodsByGoodsID(orderInfo.getGoodsID());
			orderMap.put(orderInfo, goods);
		}
		mv.addObject("ordersMap", orderMap);

		return mv;
	}

	/**
	 * �޸Ķ�����ϸ��״̬ (��̨)
	 * 
	 * @param status 1δ���� 0�ѷ��� -1δ����
	 * @param id     ����id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("updateorderinfostatus")
	public int updateOrderInfoStatus(String status, int id) {
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setOrderID(id);
		orderInfo.setOrderStatus(status);
		int code = orderInfoService.updateOrderInfo(orderInfo);
		return code;

	}

}
