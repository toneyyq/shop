package com.yq.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yq.po.City;

/**
 * 市级dao层
 * 
 * @author Administrator
 *
 */
@Repository(value = "cityDao")
public interface CityDao {
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
