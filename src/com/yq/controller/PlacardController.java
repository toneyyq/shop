package com.yq.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.yq.po.Placard;
import com.yq.service.PlacardService;

/**
 * ϵͳ����Controller��
 *
 */
@Controller
public class PlacardController {
	private PlacardService placardService;

	@Autowired
	public void setPlacardService(PlacardService placardService) {
		this.placardService = placardService;
	}

	/**
	 * ��ѯ���й���
	 * 
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping("qplacards")
	public String qPlacards(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
		// ��ҳ ҳ�룬��ҳ����
		PageHelper.startPage(pn, 5);
		List<Placard> placards = placardService.queryAllPlacard();
		// 5��ʾ��������ʾ��ҳ��
		PageInfo<Placard> page = new PageInfo<Placard>(placards, 5);
		model.addAttribute("pageInfo", page);

		return "/manage/PlacardManage";
	}

	/**
	 * ��ת��ӹ���ҳ��
	 * 
	 * @return
	 */
	@RequestMapping("toaddplacard")
	public String toAddPlacard() {
		return "/manage/placard_add";
	}

	/**
	 * ��ӹ���
	 * 
	 * @param placard
	 * @return
	 */
	@RequestMapping("addplacard")
	public String addPlacard(Placard placard) {
		int code = placardService.addPlacard(placard);
		if (code > 0) {
			return "redirect:qplacards.action";
		} else {
			return "redirect:toaddplacard.action";
		}

	}

	/**
	 * ��ת�޸Ĺ���ҳ��
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("toupdateplacard")
	public ModelAndView toUpdatePlacard(int id) {
		ModelAndView mv = new ModelAndView("/manage/placard_modify");
		Placard placard = placardService.queryPlacardById(id);
		mv.addObject("placard", placard);
		return mv;
	}

	/**
	 * �޸Ĺ���
	 * 
	 * @param placard
	 * @return
	 */
	@RequestMapping("updateplacard")
	public String updatePlacard(Placard placard, Model model) {
		int code = placardService.updatePlacard(placard);
		if (code > 0) {
			return "redirect:qplacards.action";
		} else {
			return "redirect:toupdateplacard.action?id=" + placard.getPlacardID();
		}

	}

	/**
	 * ɾ������
	 * 
	 * @param placardID
	 * @return
	 */
	@ResponseBody
	@RequestMapping("delplacard")
	public int delplacard(int placardID) {
		int code = placardService.deletePlacard(placardID);
		return code;

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

}
