package com.yq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yq.po.GoodsType;
import com.yq.service.GoodsTypeService;

/**
 * 商品类别Controller层
 *
 */
@Controller
public class GoodsTypeController {
	private GoodsTypeService goodsTypeService;

	@Autowired
	public void setGoodsTypeService(GoodsTypeService goodsTypeService) {
		this.goodsTypeService = goodsTypeService;
	}
	/**
	 *以及别获取类目
	 * @return
	 */
	public List<GoodsType> getTypesByIsLeaf(String isLeaf) {
		List<GoodsType> types=goodsTypeService.queryGoodsTypeByIsLeaf(isLeaf);
		return types;
	}

	/**
	 * 查询所有大类别
	 * 
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping("superTypes")
	public String queryAllSuperType(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
		PageHelper.startPage(pn, 10);
		// 获取一级 1商品类别列表
		List<GoodsType> list = goodsTypeService.queryGoodsTypeByParentID(0);
		// 5表示连续可显示的页数
		PageInfo<GoodsType> page = new PageInfo<GoodsType>(list, 10);
		model.addAttribute("pageInfo", page);

		return "/manage/ParameterManage";
	}

	/**
	 * 通过parentId查询商品类别
	 * 
	 * @param pid
	 * @return json数据
	 */
	@RequestMapping("qtypesbypid")
	public @ResponseBody List<GoodsType> qTypeBypid(
			@RequestBody @RequestParam(value = "typeId", defaultValue = "0") Integer pid) {
		List<GoodsType> goodsTypes = goodsTypeService.queryGoodsTypeByParentID(pid);
		return goodsTypes;
	}

	/**
	 * 跳转小类别管理页面
	 * 
	 * @param parentID
	 * @return
	 */
	@RequestMapping("subtype")
	public ModelAndView subType(Integer parentID) {
		// 获取小分类列表
		List<GoodsType> subTypes = goodsTypeService.queryGoodsTypeByParentID(parentID);
		// 大分类名称
		String superType = goodsTypeService.queryGoodsTypeBygoodsTypeID(parentID).getTypeName();
		ModelAndView mv = new ModelAndView("/manage/subType");
		mv.addObject("types", subTypes);
		mv.addObject("supname", superType);
		mv.addObject("parentID", parentID);
		return mv;
	}

	/**
	 * 删除类别(大类别不可删除）
	 * 
	 * @return
	 */
	@RequestMapping("deltype")
	public String delType(int id, int pid) {
		goodsTypeService.delGoodsType(id);
		return "redirect:subtype.action?parentID=" + pid;
	}

	/**
	 * 跳转小类别添加页面
	 * 
	 * @return
	 */
	@RequestMapping("toaddsubtype")
	public String toAddSubType(int parentID, Model model) {
		model.addAttribute("pid", parentID);
		return "/manage/subType_add";
	}

	/**
	 * 添加小类别
	 * 
	 * @param goodsType
	 * @return
	 */
	@RequestMapping("addsubtype")
	public String addSubType(GoodsType goodsType) {
		goodsType.setIsLeaf("1");
		int code = goodsTypeService.addGoodsType(goodsType);
		if (code > 0) {
			return "redirect:subtype.action?parentID=" + goodsType.getParentID();
		} else {
			return "redirect:toaddsubtype.action?parentID=" + goodsType.getParentID();
		}

	}
}
