package com.yq.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yq.po.Favorits;
import com.yq.po.Goods;
import com.yq.po.Member;
import com.yq.service.FavoritsService;

/**
 * 我的收藏控制层
 *
 */
@Controller
public class FavoriteController {
	private FavoritsService favoritsService;
	private GoodsController goodsController;

	@Autowired
	public void setFavoritsService(FavoritsService favoritsService) {
		this.favoritsService = favoritsService;
	}

	@Autowired
	public void setGoodsController(GoodsController goodsController) {
		this.goodsController = goodsController;
	}

	/**
	 * 通过memberid 获取收藏信息
	 * 
	 * @param memberID
	 * @return
	 */
	public List<Favorits> getFavoritsBymemberID(Integer memberID) {
		List<Favorits> favorits = favoritsService.queryFavoritsByMemberID(memberID);
		return favorits;
	}
	/**
	 * 取消收藏
	 * @param goodsID
	 * @return
	 */
	@ResponseBody
	@RequestMapping("delfavorite")
	public int delFavorite(int goodsID,HttpSession session) {
		int mid=((Member)session.getAttribute("member")).getMemberID();
		int code= favoritsService.delFavoritsBygoodsID(mid,goodsID);
		return code;
	}
	
	/**
	 * 添加收藏
	 * @param goodsID
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addfavorite")
	public int addFavorite(int goodsID,HttpSession session) {
		int mid=((Member)session.getAttribute("member")).getMemberID();
		Favorits favorits=new Favorits( mid, goodsID);
		int code = favoritsService.addFavorits(favorits);
		return code;
	}
	
	/**
	 * 查看是否存在收藏
	 * @param goodsID
	 * @param memberID
	 * @return
	 */
	@ResponseBody
	@RequestMapping("checkfavorite")
	public int checkFavorite(int goodsID,HttpSession session) {
		int mid=((Member)session.getAttribute("member")).getMemberID();
		Favorits favorits=favoritsService.queryByMemberIDAndGoodsID(mid, goodsID);
		int code=0;
		if (favorits != null) {
			code=1;
		}else {
			code=0;
		}
		return code;
	}
	
	/**
	 * 跳转我的收藏页面
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("mycollect")
	public ModelAndView myCollect(HttpSession session) {
		//session中获取member信息
		Member member = (Member) session.getAttribute("member");
		//会员id
		int mid = member.getMemberID();
		ModelAndView mv = new ModelAndView("/person/collection");
		//通过会员id获取收藏集合
		List<Favorits> favorits = favoritsService.queryFavoritsByMemberID(mid);
		
		//通过favorits 获得商品集合
		List<Goods> goodsList=new ArrayList<Goods>();
		for (Favorits favorite : favorits) {
			Goods goods = goodsController.getGoodsByGoodsID(favorite.getGoodsID());
			goodsList.add(goods);
		}
		mv.addObject("goodsList", goodsList);
		return mv;
	}
}
