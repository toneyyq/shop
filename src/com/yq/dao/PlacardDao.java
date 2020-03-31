package com.yq.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yq.po.Placard;

/**
 * ����dao��
 */
@Repository(value = "placardDao")
public interface PlacardDao {

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
