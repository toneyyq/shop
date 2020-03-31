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
 * ��Ʒ���Controller��
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
	 *�Լ����ȡ��Ŀ
	 * @return
	 */
	public List<GoodsType> getTypesByIsLeaf(String isLeaf) {
		List<GoodsType> types=goodsTypeService.queryGoodsTypeByIsLeaf(isLeaf);
		return types;
	}

	/**
	 * ��ѯ���д����
	 * 
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping("superTypes")
	public String queryAllSuperType(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
		PageHelper.startPage(pn, 10);
		// ��ȡһ�� 1��Ʒ����б�
		List<GoodsType> list = goodsTypeService.queryGoodsTypeByParentID(0);
		// 5��ʾ��������ʾ��ҳ��
		PageInfo<GoodsType> page = new PageInfo<GoodsType>(list, 10);
		model.addAttribute("pageInfo", page);

		return "/manage/ParameterManage";
	}

	/**
	 * ͨ��parentId��ѯ��Ʒ���
	 * 
	 * @param pid
	 * @return json����
	 */
	@RequestMapping("qtypesbypid")
	public @ResponseBody List<GoodsType> qTypeBypid(
			@RequestBody @RequestParam(value = "typeId", defaultValue = "0") Integer pid) {
		List<GoodsType> goodsTypes = goodsTypeService.queryGoodsTypeByParentID(pid);
		return goodsTypes;
	}

	/**
	 * ��תС������ҳ��
	 * 
	 * @param parentID
	 * @return
	 */
	@RequestMapping("subtype")
	public ModelAndView subType(Integer parentID) {
		// ��ȡС�����б�
		List<GoodsType> subTypes = goodsTypeService.queryGoodsTypeByParentID(parentID);
		// ���������
		String superType = goodsTypeService.queryGoodsTypeBygoodsTypeID(parentID).getTypeName();
		ModelAndView mv = new ModelAndView("/manage/subType");
		mv.addObject("types", subTypes);
		mv.addObject("supname", superType);
		mv.addObject("parentID", parentID);
		return mv;
	}

	/**
	 * ɾ�����(����𲻿�ɾ����
	 * 
	 * @return
	 */
	@RequestMapping("deltype")
	public String delType(int id, int pid) {
		goodsTypeService.delGoodsType(id);
		return "redirect:subtype.action?parentID=" + pid;
	}

	/**
	 * ��תС������ҳ��
	 * 
	 * @return
	 */
	@RequestMapping("toaddsubtype")
	public String toAddSubType(int parentID, Model model) {
		model.addAttribute("pid", parentID);
		return "/manage/subType_add";
	}

	/**
	 * ���С���
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
