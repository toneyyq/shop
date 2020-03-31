package com.yq.service;

import java.util.List;

import com.yq.po.Area;

public interface AreaService {
	/**
	 * 查询对应城市下的地区
	 * 
	 * @param cityCode
	 * @return
	 */
	List<Area> queryAllAreaByCityCode(String cityCode);

	/**
	 * 通过areaCode 查询地区
	 * 
	 * @param areaCode
	 * @return
	 */
	Area queryAreaByAreaCode(String areaCode);
}
