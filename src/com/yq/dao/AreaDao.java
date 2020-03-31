package com.yq.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yq.po.Area;
/**
 * ����dao��
 *
 */
@Repository(value = "areaDao")
public interface AreaDao {
	/**
	 * ��ѯ��Ӧ�����µĵ���
	 * @param cityCode
	 * @return
	 */
	List<Area> queryAllAreaByCityCode(String cityCode);

	/**
	 * ͨ��areaCode ��ѯ����
	 * 
	 * @param areaCode
	 * @return
	 */
	Area queryAreaByAreaCode(String areaCode);
}
