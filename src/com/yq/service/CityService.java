package com.yq.service;

import java.util.List;

import com.yq.po.City;

public interface CityService {
	/**
	 * ��ѯ��Ӧʡ���µĳ���
	 * 
	 * @return
	 */
	List<City> queryAllCityByProvinceCode(String provinceCode);

	/**
	 * ͨ�����д����ѯ����
	 * 
	 * @param cityCode
	 * @return
	 */
	City queryCityByCityCode(String cityCode);
}
