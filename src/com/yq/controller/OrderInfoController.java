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
 * 订单控制层
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
	 * 处理日期格式
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	/**
	 * 删除订单
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
	 * 修改订单，跳转支付结束提示界面
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
		// 商品数量变更
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
	 * 修改订单地址
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
	 * 跳转订单确认付款页面pay.jsp
	 * 
	 * @param orderID
	 * @param session
	 * @return
	 */
	@RequestMapping("topay")
	public ModelAndView toPay(Integer orderID, HttpSession session) {
		ModelAndView mv = new ModelAndView("/person/pay");
		// 1.获取member信息
		int mid = ((Member) session.getAttribute("member")).getMemberID();
		// 2.获取地址集合
		List<MemberAddressBook> addressBooks = memberAddressBookService.queryMemberAddressBooksByMemberID(mid);
		MemberAddressBook defaultAddressBook = new MemberAddressBook();
		for (MemberAddressBook memberAddressBook : addressBooks) {
			if ("1".equals(memberAddressBook.getTatus())) {
				defaultAddressBook = memberAddressBook;
			}
		}
		addressBooks.remove(defaultAddressBook);
		// 3.订单详情
		OrderInfo orderInfo = orderInfoService.queryOrderInfoByOrderID(orderID);
		// 5.商品信息
		Goods goods = goodService.queryGoodsByGoodsID(orderInfo.getGoodsID());

		// 默认地址信息
		mv.addObject("defaddress", defaultAddressBook);
		// 会员所有地址（无默认地址）
		mv.addObject("addressBooks", addressBooks);
		// 商品信息
		mv.addObject("goods", goods);
		// 订单信息
		mv.addObject("orderInfo", orderInfo);
		return mv;
	}

	/**
	 * 创建订单
	 * 
	 * @param orderInfo
	 * @param session
	 * @return
	 */
	@RequestMapping("toaddorder")
	public String toAddOrder(OrderInfo orderInfo, HttpSession session) {
		// 1.获取member信息
		int mid = ((Member) session.getAttribute("member")).getMemberID();
		// 2.获取地址id(默认地址）
		List<MemberAddressBook> addressBooks = memberAddressBookService.queryMemberAddressBooksByMemberID(mid);
		MemberAddressBook defaultAddressBook = null;
		for (MemberAddressBook memberAddressBook : addressBooks) {
			if ("1".equals(memberAddressBook.getTatus())) {
				defaultAddressBook = memberAddressBook;
			}
		}
		// 跳转去设置默认地址
		if (defaultAddressBook == null) {
			return "redirect:myaddress.do";
		} else {
			orderInfo.setId(defaultAddressBook.getId());
			// 3.付款方式集合
			orderInfo.setOrderPay("余额");
			// 4.发货方式集合
			orderInfo.setOrderCarry("中通");
			// 5.商品信息
			Goods goods = goodService.queryGoodsByGoodsID(orderInfo.getGoodsID());

			// 6.订单信息设置
			// 未付款状态
			if (orderInfo.getGoodsCount() == null) {
				orderInfo.setGoodsCount(1);
			}
			// 总额
			orderInfo.setOrderAmount(orderInfo.getGoodsCount() * goods.getGoodsMemberPrice());
			// 未付款
			orderInfo.setOrderStatus("-1");
			// memberID
			orderInfo.setMemberID(mid);
			// 创建时间
			orderInfo.setCreateDate(new Date());
			// 7.向数据库添加默认订单
			orderInfoService.addOrderInfo(orderInfo);
			//删除购物车
			cartGoodsService.deleteCartGoodsBymemberIDAndGoodsID(mid, orderInfo.getGoodsID());

			// 8.获取最后添加的订单号
			int orderID = orderInfoService.getNewDataId(mid);

			// 跳转支付页面
			return "redirect:topay.do?orderID=" + orderID;
		}

	}

	/**
	 * 查询所有订单记录
	 * 
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping("qorders")
	public String qOrderInfos(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
		// 分页 页码，单页容量
		PageHelper.startPage(pn, 5);
		List<OrderInfo> orderInfos = orderInfoService.queryAllOrderInfo();

		// 5表示连续可显示的页数
		PageInfo<OrderInfo> page = new PageInfo<OrderInfo>(orderInfos, 5);

		model.addAttribute("pageInfo", page);

		return "manage/OrderManage";
	}

	/**
	 * 查询订单 通过id和状态
	 * 
	 * @param id     订单号
	 * @param status 状态
	 * @param pn     页码
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
		// 分页 页码，单页容量
		PageHelper.startPage(pn, 5);
		List<OrderInfo> orderInfos = orderInfoService.queryOrderInfoByIdAndStatus(id, status);
		// 5表示连续可显示的页数
		PageInfo<OrderInfo> page = new PageInfo<OrderInfo>(orderInfos, 5);
		mv.addObject("pageInfo", page);
		return mv;
	}

	/**
	 * 我的订单页面
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
	 * 修改订单明细的状态 (后台)
	 * 
	 * @param status 1未发货 0已发货 -1未付款
	 * @param id     订单id
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
