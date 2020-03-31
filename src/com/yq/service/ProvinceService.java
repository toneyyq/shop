package com.yq.service;

import java.util.List;

import com.yq.po.Province;

public interface ProvinceService {
	/**
	 * 查询所有省份
	 * 
	 * @return
	 */
	List<Province> queryAllProvince();

	/**
	 * 通过provinceCode查询省份
	 * 
	 * @param provinceCode
	 * @return
	 */
	Province queryProvinceByProvinceCode(String provinceCode);

}
