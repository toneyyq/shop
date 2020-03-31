package com.yq.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yq.po.Province;
/**
 *ʡ��dao��
 */
@Repository(value = "provinceDao")
public interface ProvinceDao {
	/**
	 * ��ѯ����ʡ��
	 * 
	 * @return	����ʡ���б�
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
