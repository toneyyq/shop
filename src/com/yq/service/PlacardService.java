package com.yq.service;

import java.util.List;

import com.yq.po.Placard;

public interface PlacardService {
	/**
	 * ��ӹ���
	 * 
	 * @param placard
	 * @return
	 */
	int addPlacard(Placard placard);

	/**
	 * �޸Ĺ���
	 * 
	 * @param placard
	 * @return
	 */
	int updatePlacard(Placard placard);

	/**
	 * ɾ������
	 * 
	 * @param id
	 * @return
	 */
	int deletePlacard(int id);

	/**
	 * ͨ������id��ѯ����
	 * 
	 * @param id
	 * @return
	 */
	Placard queryPlacardById(int id);

	/**
	 * ��ȡ���й���
	 * 
	 * @return
	 */
	List<Placard> queryAllPlacard();
}
