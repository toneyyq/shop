package com.yq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yq.dao.FavoritsDao;
import com.yq.po.Favorits;
import com.yq.service.FavoritsService;
@Service("favoritsService")
public class FavoritsServiceImpl implements FavoritsService {
	private FavoritsDao favoritsDao;
	@Autowired
	public void setFavoritsDao(FavoritsDao favoritsDao) {
		this.favoritsDao = favoritsDao;
	}

	@Override
	public int addFavorits(Favorits favorits) {
		// TODO Auto-generated method stub
		try {
			return favoritsDao.addFavorits(favorits);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delFavorits(int id) {
		// TODO Auto-generated method stub
		try {
			return favoritsDao.delFavorits(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Favorits> queryFavoritsByMemberID(int memberID) {
		// TODO Auto-generated method stub
		try {
			return favoritsDao.queryFavoritsByMemberID(memberID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Favorits queryByMemberIDAndGoodsID(int memberID, int goodsID) {
		// TODO Auto-generated method stub
		try {
			return favoritsDao.queryByMemberIDAndGoodsID(memberID, goodsID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int delFavoritsBygoodsID(int memberID,int goodsID) {
		// TODO Auto-generated method stub
		try {
			return favoritsDao.delFavoritsBygoodsID(memberID, goodsID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
