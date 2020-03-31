package com.yq.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yq.po.City;

/**
 * �м�dao��
 * 
 * @author Administrator
 *
 */
@Repository(value = "cityDao")
public interface CityDao {
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
