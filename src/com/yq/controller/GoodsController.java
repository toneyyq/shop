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
 * ��Ʒ���Ʋ�goods
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
	 * �Ƽ�������Ʒ
	 * @param count ����
	 * @return
	 */
	public List<Goods> getNewGoods(Integer count) {
		List<Goods> goods=goodsService.queryNewGoods(count);
		return goods;
		
	}

	/**
	 * ͨ��id��ѯ��Ʒ
	 * 
	 * @param goodID
	 * @return
	 */
	public Goods getGoodsByGoodsID(Integer goodID) {
		Goods goods = goodsService.queryGoodsByGoodsID(goodID);
		return goods;
	}

	/**
	 * ��ת�����Ʒҳ��goods_add.jsp
	 * 
	 * @return
	 */
	@RequestMapping("toaddgoods")
	public String toaddGoods() {

		return "/manage/goods_add";
	}

	/**
	 * ��ת��Ʒ��Ϣҳ��(��̨)
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
	 * ��ת��Ʒ��Ϣ���棨ǰ̨��
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("tointroduction")
	public ModelAndView toIntroduction(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Integer id) {
		ModelAndView mv = new ModelAndView("introduction");
		Goods goodsInfo = goodsService.queryGoodsByGoodsID(id);
		// ����ϲ��
		List<Goods> goods = goodsService.queryGoodsByTypeCode(goodsInfo.getTypeCode());

		// �����ֿ������У�
		// ��ҳ ҳ�룬��ҳ����
		PageHelper.startPage(pn, 8);
		List<Goods> allGoods = goodsService.queryAllGoods();
		// 5��ʾ��������ʾ��ҳ��
		PageInfo<Goods> page = new PageInfo<Goods>(allGoods, 6);
		mv.addObject("goodsInfo", goodsInfo);
		mv.addObject("goods", goods);
		mv.addObject("pageInfo", page);
		return mv;
	}

	/**
	 * ��ѯ������Ʒ
	 * 
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping("queryAllGoods")
	public String queryAllGoods(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
		// ��ҳ ҳ�룬��ҳ����
		PageHelper.startPage(pn, 5);
		List<Goods> goods = goodsService.queryAllGoods();
		// 5��ʾ��������ʾ��ҳ��
		PageInfo<Goods> page = new PageInfo<Goods>(goods, 5);
		model.addAttribute("pageInfo", page);
		return "/manage/GoodsManage";
	}

	/**
	 * ͨ������ ������ģ����ѯ��Ʒ��ǰ̨��
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
		// ��ȡ������Ŀ
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
	 * ��� �ϴ���Ʒ
	 * 
	 * @param goods
	 * @param goodsPicture
	 * @param request
	 * @return
	 */
	@RequestMapping("addGoods")
	public String addGoods(Goods goods, MultipartFile goodPic, HttpServletRequest request) {
		// ����Ϊ��Ч��Ʒ
		goods.setIsValid("1");
		if (goodPic != null) {
			// �����ļ��ϴ�
			// ��Ŀ��ʵ·��
			String realPath = request.getRealPath("/");
			// �ϴ���ԭʼ�ļ���
			String oldFileName = goodPic.getOriginalFilename();
			// �ϴ�������ļ���
			String newFileName = "/img/sp/" + UUID.randomUUID() + oldFileName.substring(oldFileName.lastIndexOf("."));
			// ���ļ����λ��
			File file = new File(realPath + newFileName);
			// д���ļ�
			try {
				goodPic.transferTo(file);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				System.err.println("addGoods()д���ļ�����!");
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
	 * ��ת�޸���Ʒҳ�棬��ʾ�޸���Ʒ����Ϣ
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
	 * �޸���Ʒgoods����
	 * 
	 * @return
	 */
	@RequestMapping("updateGoods")
	public String updateGoods(Goods goods, MultipartFile goodPic, HttpServletRequest request) {
		if (goodPic != null) {
			// �����ļ��ϴ�
			// ��Ŀ��ʵ·��
			String realPath = request.getRealPath("/");
			// �ϴ���ԭʼ�ļ���
			String oldFileName = goodPic.getOriginalFilename();
			// �ϴ�������ļ���
			String newFileName = "/img/sp/" + UUID.randomUUID() + oldFileName.substring(oldFileName.lastIndexOf("."));
			// ���ļ����λ��
			File file = new File(realPath + newFileName);
			// д���ļ�
			try {
				goodPic.transferTo(file);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				System.err.println("update()д���ļ�����!");
				e.printStackTrace();
			}
			goods.setGoodsPicture(newFileName);

		}
		int code = goodsService.updateGoods(goods);
		if (code > 0) {
			// �޸ĳɹ�
			return "redirect:queryAllGoods.action";
		} else {
			// �޸�ʧ��
			return "redirect:toeditgoods.action";
		}

	}

	/**
	 * ����
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
	 * ��Ʒ�ı��ؼ�״��
	 * 
	 * @param goodsID
	 * @param isSale  1�ؼ� 0���ؼ�
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
	 * �ı���Ʒ״̬
	 * 
	 * @param goodsID
	 * @param isValid 1��Ч 0��Ч
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
	 * ͨ��typecode��goodsName��ѯ��Ʒ
	 * 
	 * @param typeCode
	 * @param goodsName ģ����ѯ
	 * @return
	 */
	@RequestMapping("sgbytypeandname")
	public ModelAndView selectGoodsByTypeAndName(String typeCode, String goodsName,
			@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		ModelAndView mv = new ModelAndView("/manage/GoodsManage");
		// ��ҳ ҳ�룬��ҳ����
		if ("".equals(goodsName)) {
			goodsName = null;
		}
		if ("null".equals(typeCode)) {
			typeCode = null;
		}
		PageHelper.startPage(pn, 5);
		List<Goods> goods = goodsService.queryGoodsByTypeCodeAndGoodsName(typeCode, goodsName);
		// 5��ʾ��������ʾ��ҳ��
		PageInfo<Goods> page = new PageInfo<Goods>(goods, 5);
		mv.addObject("pageInfo", page);
		return mv;
	}

}
