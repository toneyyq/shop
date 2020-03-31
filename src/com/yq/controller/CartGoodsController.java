package com.yq.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yq.po.CartGoods;
import com.yq.po.Goods;
import com.yq.po.Member;
import com.yq.service.CartGoodsService;

/**
 * ���ﳵ���Ʋ�
 * 
 * @author Administrator
 *
 */
@Controller
public class CartGoodsController {
	private CartGoodsService cartGoodsService;
	private GoodsController goodsController;

	@Autowired
	public void setCartGoodsService(CartGoodsService cartGoodsService) {
		this.cartGoodsService = cartGoodsService;
	}

	@Autowired
	public void setGoodsController(GoodsController goodsController) {
		this.goodsController = goodsController;
	}
	/**
	 * ���ﳵ������
	 * @return
	 */
	@ResponseBody
	@RequestMapping("cartcount")
	public int cartCount(HttpSession session) {
		int mid= ((Member)session.getAttribute("member")).getMemberID();
		int count = cartGoodsService.getCount(mid);
		return count;
	}
	
	/**
	 * ɾ�����ﳵ��Ʒ
	 * @param cartID
	 * @return
	 */
	@ResponseBody
	@RequestMapping("delcart")
	public int delCart(int cartID) {
		int code=cartGoodsService.deleteCartGoods(cartID);
		return code;
	}

	/**
	 * �����Ʒ�����ﳵ
	 * 
	 * @param cartGoods
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addcart")
	public int addCartGoods(CartGoods cartGoods, HttpSession session) {
		// 1.��ȡmember��Ϣ
		int mid = ((Member) session.getAttribute("member")).getMemberID();
		cartGoods.setMemberID(mid);
		// 2.�鿴���ﳵ���Ƿ��Ѿ��и���Ʒ
		CartGoods dataCartGoods = cartGoodsService.queryBymemberIDAndgoodsID(mid, cartGoods.getGoodsID());
		// 3.�����Ʒ
		if (dataCartGoods != null) {
			dataCartGoods.setGoodsCount(dataCartGoods.getGoodsCount() + cartGoods.getGoodsCount());
			int code = cartGoodsService.updateCartGoods(dataCartGoods);
			return code;
		} else {
			int code = cartGoodsService.addCartGoods(cartGoods);
			return code;
		}

	}

	/**
	 * ���ﳵ��ת ��ʾ����
	 * 
	 * @return
	 */
	@RequestMapping("cart")
	public ModelAndView cart(HttpSession session) {
		ModelAndView mv = new ModelAndView("person/shopcart");
		Member member = (Member) session.getAttribute("member");
		int mid = member.getMemberID();
		List<CartGoods> cartGoods = cartGoodsService.queryCartGoodsByMemberId(mid);
		Map<CartGoods, Goods> cartMap=new LinkedHashMap<CartGoods, Goods>();
		for (CartGoods cartGood : cartGoods) {
			Goods goods=goodsController.getGoodsByGoodsID(cartGood.getGoodsID());
			cartMap.put(cartGood, goods);
		}

		mv.addObject("cartmap", cartMap);
		return mv;
	}

}
