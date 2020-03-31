package com.yq.service;

import java.util.List;

import com.yq.po.Province;

public interface ProvinceService {
	/**
	 * ��ѯ����ʡ��
	 * 
	 * @return
	 */
	List<Province> queryAllProvince();

	/**
	 * ͨ��provinceCode��ѯʡ��
	 * 
	 * @param provinceCode
	 * @return
	 */
	Province queryProvinceByProvinceCode(String provinceCode);

}
