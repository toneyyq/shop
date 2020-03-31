package com.yq.service;

import java.util.List;

import com.yq.po.Area;

public interface AreaService {
	/**
	 * ��ѯ��Ӧ�����µĵ���
	 * 
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
