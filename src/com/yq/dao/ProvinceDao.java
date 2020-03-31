package com.yq.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yq.po.Province;
/**
 *省份dao层
 */
@Repository(value = "provinceDao")
public interface ProvinceDao {
	/**
	 * 查询所有省份
	 * 
	 * @return	所有省份列表
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
