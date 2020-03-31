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
 * 系统公告Controller层
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
	 * 查询所有公告
	 * 
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping("qplacards")
	public String qPlacards(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
		// 分页 页码，单页容量
		PageHelper.startPage(pn, 5);
		List<Placard> placards = placardService.queryAllPlacard();
		// 5表示连续可显示的页数
		PageInfo<Placard> page = new PageInfo<Placard>(placards, 5);
		model.addAttribute("pageInfo", page);

		return "/manage/PlacardManage";
	}

	/**
	 * 跳转添加公告页面
	 * 
	 * @return
	 */
	@RequestMapping("toaddplacard")
	public String toAddPlacard() {
		return "/manage/placard_add";
	}

	/**
	 * 添加公告
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
	 * 跳转修改公告页面
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
	 * 修改公告
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
	 * 删除公告
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
	 * 处理日期格式
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

}
