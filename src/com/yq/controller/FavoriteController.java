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
 * �ҵ��ղؿ��Ʋ�
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
	 * ͨ��memberid ��ȡ�ղ���Ϣ
	 * 
	 * @param memberID
	 * @return
	 */
	public List<Favorits> getFavoritsBymemberID(Integer memberID) {
		List<Favorits> favorits = favoritsService.queryFavoritsByMemberID(memberID);
		return favorits;
	}
	/**
	 * ȡ���ղ�
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
	 * ����ղ�
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
	 * �鿴�Ƿ�����ղ�
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
	 * ��ת�ҵ��ղ�ҳ��
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("mycollect")
	public ModelAndView myCollect(HttpSession session) {
		//session�л�ȡmember��Ϣ
		Member member = (Member) session.getAttribute("member");
		//��Աid
		int mid = member.getMemberID();
		ModelAndView mv = new ModelAndView("/person/collection");
		//ͨ����Աid��ȡ�ղؼ���
		List<Favorits> favorits = favoritsService.queryFavoritsByMemberID(mid);
		
		//ͨ��favorits �����Ʒ����
		List<Goods> goodsList=new ArrayList<Goods>();
		for (Favorits favorite : favorits) {
			Goods goods = goodsController.getGoodsByGoodsID(favorite.getGoodsID());
			goodsList.add(goods);
		}
		mv.addObject("goodsList", goodsList);
		return mv;
	}
}
