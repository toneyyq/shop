package com.yq.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yq.po.Goods;
import com.yq.po.GoodsType;
import com.yq.po.Placard;
import com.yq.service.GoodService;
import com.yq.service.GoodsTypeService;
import com.yq.service.PlacardService;
/**
 * 主页控制器
 * @author Administrator
 *
 */
@Controller
public class IndexController {
	private GoodsTypeService goodsTypeService;
	private GoodService goodService;
	private PlacardService placardService;
	@Autowired
	public void setGoodsTypeService(GoodsTypeService goodsTypeService) {
		this.goodsTypeService = goodsTypeService;
	}
	@Autowired
	public void setGoodService(GoodService goodService) {
		this.goodService = goodService;
	}
	@Autowired
	public void setPlacardService(PlacardService placardService) {
		this.placardService = placardService;
	}
	
	/**
	 * 主页
	 * @param pn
	 * @return
	 */
	@RequestMapping("toindex")
	public ModelAndView toIndex(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		
		ModelAndView mv=new ModelAndView("index");
		List<GoodsType>	types=goodsTypeService.queryGoodsTypeByParentID(0);
		List<Goods> goods=goodService.queryAllGoods();
		List<Placard> placards= placardService.queryAllPlacard();
		Map<String, List<GoodsType>> typeMap= new LinkedHashMap<String, List<GoodsType>>();
		//类别二级
		for (GoodsType type : types) {
			typeMap.put(type.getTypeName(), goodsTypeService.queryGoodsTypeByParentID(type.getTypeID()));
		}
		//商品分页
		PageHelper.startPage(pn, 10);
		PageInfo<Goods> page = new PageInfo<Goods>(goods, 5);
		mv.addObject("typeMap",typeMap);
		mv.addObject("pageInfo", page);
		mv.addObject("placards", placards);
		return mv;
	}
	
	
	
	
	
	
}
