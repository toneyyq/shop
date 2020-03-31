package com.yq.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yq.po.Area;
/**
 * 区级dao层
 *
 */
@Repository(value = "areaDao")
public interface AreaDao {
	/**
	 * 查询对应城市下的地区
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
