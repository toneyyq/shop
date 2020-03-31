package com.yq.service;

import java.util.List;

import com.yq.po.City;

public interface CityService {
	/**
	 * 查询对应省市下的城市
	 * 
	 * @return
	 */
	List<City> queryAllCityByProvinceCode(String provinceCode);

	/**
	 * 通过城市代码查询城市
	 * 
	 * @param cityCode
	 * @return
	 */
	City queryCityByCityCode(String cityCode);
}
