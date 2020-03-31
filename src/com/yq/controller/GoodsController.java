package com.yq.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yq.po.Goods;
import com.yq.po.GoodsType;
import com.yq.service.GoodService;

/**
 * 商品控制层goods
 * 
 * @author Administrator
 *
 */
@Controller
public class GoodsController {

	private GoodService goodsService;
	private GoodsTypeController goodsTypeController;

	@Autowired
	public void setGoodsService(GoodService goodsService) {
		this.goodsService = goodsService;
	}

	@Autowired
	public void setGoodsTypeController(GoodsTypeController goodsTypeController) {
		this.goodsTypeController = goodsTypeController;
	}
	/**
	 * 推荐最新商品
	 * @param count 数量
	 * @return
	 */
	public List<Goods> getNewGoods(Integer count) {
		List<Goods> goods=goodsService.queryNewGoods(count);
		return goods;
		
	}

	/**
	 * 通过id查询商品
	 * 
	 * @param goodID
	 * @return
	 */
	public Goods getGoodsByGoodsID(Integer goodID) {
		Goods goods = goodsService.queryGoodsByGoodsID(goodID);
		return goods;
	}

	/**
	 * 跳转添加商品页面goods_add.jsp
	 * 
	 * @return
	 */
	@RequestMapping("toaddgoods")
	public String toaddGoods() {

		return "/manage/goods_add";
	}

	/**
	 * 跳转商品信息页面(后台)
	 * 
	 * @return
	 */
	@RequestMapping("togoodsinfo")
	public ModelAndView toGoodsDetails(int id) {
		ModelAndView mv = new ModelAndView("/manage/goods_detail");
		Goods goods = goodsService.queryGoodsByGoodsID(id);
		mv.addObject("goods", goods);
		return mv;
	}

	/**
	 * 跳转商品信息界面（前台）
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("tointroduction")
	public ModelAndView toIntroduction(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Integer id) {
		ModelAndView mv = new ModelAndView("introduction");
		Goods goodsInfo = goodsService.queryGoodsByGoodsID(id);
		// 猜你喜欢
		List<Goods> goods = goodsService.queryGoodsByTypeCode(goodsInfo.getTypeCode());

		// 看了又看（所有）
		// 分页 页码，单页容量
		PageHelper.startPage(pn, 8);
		List<Goods> allGoods = goodsService.queryAllGoods();
		// 5表示连续可显示的页数
		PageInfo<Goods> page = new PageInfo<Goods>(allGoods, 6);
		mv.addObject("goodsInfo", goodsInfo);
		mv.addObject("goods", goods);
		mv.addObject("pageInfo", page);
		return mv;
	}

	/**
	 * 查询所有商品
	 * 
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping("queryAllGoods")
	public String queryAllGoods(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
		// 分页 页码，单页容量
		PageHelper.startPage(pn, 5);
		List<Goods> goods = goodsService.queryAllGoods();
		// 5表示连续可显示的页数
		PageInfo<Goods> page = new PageInfo<Goods>(goods, 5);
		model.addAttribute("pageInfo", page);
		return "/manage/GoodsManage";
	}

	/**
	 * 通过名字 ，类型模糊查询商品（前台）
	 * 
	 * @param goodsName
	 * @return
	 */
	@RequestMapping("qgoodsbynameortype")
	public ModelAndView queryGoodsByName(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value = "goodsName", defaultValue = "") String goodsName,
			@RequestParam(value = "type", defaultValue = "") String type) {
		ModelAndView mv = new ModelAndView("sort");
		if ("".equals(type)) {
			type = null;
		}
		if ("".equals(goodsName)) {
			goodsName = null;
		}
		// 获取二级类目
		List<GoodsType> types = goodsTypeController.getTypesByIsLeaf("1");
		PageHelper.startPage(pn, 8);
		List<Goods> goods = goodsService.queryGoodsByTypeCodeAndGoodsName(type, goodsName);
		PageInfo<Goods> page = new PageInfo<Goods>(goods, 6);

		mv.addObject("pageInfo", page);
		mv.addObject("goodsName", goodsName);
		mv.addObject("type", type);
		mv.addObject("types", types);
		return mv;
	}

	/**
	 * 添加 上传商品
	 * 
	 * @param goods
	 * @param goodsPicture
	 * @param request
	 * @return
	 */
	@RequestMapping("addGoods")
	public String addGoods(Goods goods, MultipartFile goodPic, HttpServletRequest request) {
		// 设置为有效商品
		goods.setIsValid("1");
		if (goodPic != null) {
			// 进行文件上传
			// 项目真实路径
			String realPath = request.getRealPath("/");
			// 上传的原始文件名
			String oldFileName = goodPic.getOriginalFilename();
			// 上传后的新文件名
			String newFileName = "/img/sp/" + UUID.randomUUID() + oldFileName.substring(oldFileName.lastIndexOf("."));
			// 新文件存放位置
			File file = new File(realPath + newFileName);
			// 写入文件
			try {
				goodPic.transferTo(file);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				System.err.println("addGoods()写入文件出错!");
				e.printStackTrace();
			}
			goods.setGoodsPicture(newFileName);

		}
		int code = goodsService.addGoods(goods);
		if (code > 0) {
			return "redirect:queryAllGoods.action";
		} else {
			return "redirect:toaddgoods.action";
		}
	}

	/**
	 * 跳转修改商品页面，显示修改商品的信息
	 * 
	 * @param goodsID
	 * @return
	 */
	@RequestMapping("toeditgoods")
	public ModelAndView editGoods(@RequestParam(value = "id") int goodsID) {
		ModelAndView mv = new ModelAndView("manage/goods_modify");
		Goods goods = goodsService.queryGoodsByGoodsID(goodsID);
		mv.addObject("goods", goods);
		return mv;
	}

	/**
	 * 修改商品goods数据
	 * 
	 * @return
	 */
	@RequestMapping("updateGoods")
	public String updateGoods(Goods goods, MultipartFile goodPic, HttpServletRequest request) {
		if (goodPic != null) {
			// 进行文件上传
			// 项目真实路径
			String realPath = request.getRealPath("/");
			// 上传的原始文件名
			String oldFileName = goodPic.getOriginalFilename();
			// 上传后的新文件名
			String newFileName = "/img/sp/" + UUID.randomUUID() + oldFileName.substring(oldFileName.lastIndexOf("."));
			// 新文件存放位置
			File file = new File(realPath + newFileName);
			// 写入文件
			try {
				goodPic.transferTo(file);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				System.err.println("update()写入文件出错!");
				e.printStackTrace();
			}
			goods.setGoodsPicture(newFileName);

		}
		int code = goodsService.updateGoods(goods);
		if (code > 0) {
			// 修改成功
			return "redirect:queryAllGoods.action";
		} else {
			// 修改失败
			return "redirect:toeditgoods.action";
		}

	}

	/**
	 * 补货
	 * 
	 * @param goodsID
	 * @param addNumber
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addgNumber")
	public Integer addGoodsNumber(int goodsID, @RequestParam(value = "addNumber", defaultValue = "0") int addNumber) {
		Goods goods = goodsService.queryGoodsByGoodsID(goodsID);
		int goodsNumber = goods.getGoodsNumber() + addNumber;
		goods.setGoodsNumber(goodsNumber);
		int code = goodsService.updateGoods(goods);
		if (code > 0) {
			return goodsNumber;
		} else {
			return 0;
		}

	}

	/**
	 * 商品改变特价状况
	 * 
	 * @param goodsID
	 * @param isSale  1特价 0非特价
	 * @return
	 */

	@RequestMapping("gsale")
	public @ResponseBody String goodsSale(int goodsID, String isSale) {
		Goods goods = goodsService.queryGoodsByGoodsID(goodsID);
		goods.setIsSale(isSale);
		int code = goodsService.updateGoods(goods);
		if (code > 0) {
			return goods.getIsSale();
		} else {
			return "-1";
		}

	}

	/**
	 * 改变商品状态
	 * 
	 * @param goodsID
	 * @param isValid 1有效 0无效
	 * @return
	 */

	@RequestMapping("gvalid")
	public @ResponseBody String goodsValid(int goodsID, String isValid) {
		int code = goodsService.updateGoodsValid(goodsID, isValid);
		if (code > 0) {
			return isValid;
		} else {
			return "-1";
		}
	}

	/**
	 * 通过typecode和goodsName查询商品
	 * 
	 * @param typeCode
	 * @param goodsName 模糊查询
	 * @return
	 */
	@RequestMapping("sgbytypeandname")
	public ModelAndView selectGoodsByTypeAndName(String typeCode, String goodsName,
			@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		ModelAndView mv = new ModelAndView("/manage/GoodsManage");
		// 分页 页码，单页容量
		if ("".equals(goodsName)) {
			goodsName = null;
		}
		if ("null".equals(typeCode)) {
			typeCode = null;
		}
		PageHelper.startPage(pn, 5);
		List<Goods> goods = goodsService.queryGoodsByTypeCodeAndGoodsName(typeCode, goodsName);
		// 5表示连续可显示的页数
		PageInfo<Goods> page = new PageInfo<Goods>(goods, 5);
		mv.addObject("pageInfo", page);
		return mv;
	}

}
