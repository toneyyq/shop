package com.yq.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yq.po.Area;
import com.yq.po.City;
import com.yq.po.Member;
import com.yq.po.MemberAddressBook;
import com.yq.po.Province;
import com.yq.service.AreaService;
import com.yq.service.CityService;
import com.yq.service.MemberAddressBookService;
import com.yq.service.ProvinceService;

@Controller
public class AddressController {
	private MemberAddressBookService memberAddressBookService;
	private ProvinceService provinceService;
	private CityService cityService;
	private AreaService areaService;

	@Autowired
	public void setMemberAddressBookService(MemberAddressBookService memberAddressBookService) {
		this.memberAddressBookService = memberAddressBookService;
	}

	@Autowired
	public void setProvinceService(ProvinceService provinceService) {
		this.provinceService = provinceService;
	}

	@Autowired
	public void setCityService(CityService cityService) {
		this.cityService = cityService;
	}

	@Autowired
	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}
	/**
	 * ����Ĭ�ϵ�ַ
	 * @param id
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("setdefaddress")
	public int setDefaultAddress(int id,HttpSession session) {
		//1.��ȡ��Ա��Ϣ
		int mid=((Member)session.getAttribute("member")).getMemberID();
		//2.������ݿ�֮ǰĬ�ϵ�ַ
		memberAddressBookService.delAddressDefault(mid);
		//3.������Ĭ�ϵ�ַ
		int code=memberAddressBookService.updateAddressDefault(id);
		if (code>0) {
			return id;
		}else {
			return code;
		}
		
	}

	/**
	 * ��ת�ҵ��ջ���ַҳ��
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("myaddress")
	public ModelAndView myAddress(HttpSession session) {
		Member member = (Member) session.getAttribute("member");
		// ��Աid
		int mid = member.getMemberID();
		ModelAndView mv = new ModelAndView("/person/address");
		MemberAddressBook defAddressBook=null;
		List<MemberAddressBook> addressBooks = memberAddressBookService.queryMemberAddressBooksByMemberID(mid);
		for (MemberAddressBook memberAddressBook : addressBooks) {
			if ("1".equals(memberAddressBook.getTatus())) {
				defAddressBook=memberAddressBook;
			}
		}
		addressBooks.remove(defAddressBook);
		mv.addObject("defaddress", defAddressBook);
		mv.addObject("address", addressBooks);

		return mv;
	}
	/**
	 * ��ӵ�ַ��ajax��
	 * @param memberAddressBook
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addAddress")
	public int addAddress(MemberAddressBook memberAddressBook) {
		String province=provinceService.queryProvinceByProvinceCode(memberAddressBook.getProvinceCode()).getProvince();
		String city=cityService.queryCityByCityCode(memberAddressBook.getCityCode()).getCity();
		String area=areaService.queryAreaByAreaCode(memberAddressBook.getAreaCode()).getArea();
		memberAddressBook.setProvinceCode(province);
		memberAddressBook.setCityCode(city);
		memberAddressBook.setAreaCode(area);
		int code=memberAddressBookService.addMemberAddressBook(memberAddressBook);
		return code;
	}
	
	/**
	 * ��ӵ�ַ
	 * @param memberAddressBook
	 * @return
	 */
	@RequestMapping("insertaddress")
	public String insertAddress(MemberAddressBook memberAddressBook) {
		String province=provinceService.queryProvinceByProvinceCode(memberAddressBook.getProvinceCode()).getProvince();
		String city=cityService.queryCityByCityCode(memberAddressBook.getCityCode()).getCity();
		String area=areaService.queryAreaByAreaCode(memberAddressBook.getAreaCode()).getArea();
		memberAddressBook.setProvinceCode(province);
		memberAddressBook.setCityCode(city);
		memberAddressBook.setAreaCode(area);
		//�ж��Ƿ�Ϊ�״���ӵ�ַ
		List<MemberAddressBook> memberAddressBooks=memberAddressBookService.queryMemberAddressBooksByMemberID(memberAddressBook.getMemberID());
		if (memberAddressBooks == null) {
			memberAddressBook.setTatus("1");
		}
		memberAddressBookService.addMemberAddressBook(memberAddressBook);
		return "redirect:myaddress.do";
		
	}
	/**
	 * ɾ����ַ
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("deladdress")
	public int delAddress(Integer id) {
		return memberAddressBookService.delMemberAddressBook(id);
	}
	/**
	 * ͨ��id��ȡ��ַ
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getaddressbyid")
	public MemberAddressBook getAddressById(int id) {
		MemberAddressBook address=memberAddressBookService.queryMemberAddressBookByID(id);
		return address;
	}

	/**
	 * ��ȡ����ʡ����Ϣ
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getprovinces")
	public List<Province> getProvinces() {
		List<Province> provinces = provinceService.queryAllProvince();

		return provinces;
	}

	/**
	 * ͨ��ʡ�д����ȡ������Ϣ�б�
	 * 
	 * @param provinceCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getcities")
	public List<City> getCities(String provinceCode) {
		List<City> cities = cityService.queryAllCityByProvinceCode(provinceCode);

		return cities;
	}

	/**
	 * ͨ�����д����ȡ�����б�
	 * 
	 * @param cityCode
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getareas")
	public List<Area> getAreas(String cityCode) {
		List<Area> areas = areaService.queryAllAreaByCityCode(cityCode);
		
		return areas;
	}

}
