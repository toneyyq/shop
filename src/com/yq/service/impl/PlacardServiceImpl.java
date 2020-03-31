package com.yq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yq.dao.PlacardDao;
import com.yq.po.Placard;
import com.yq.service.PlacardService;
@Service("placardService")
public class PlacardServiceImpl implements PlacardService {
	private PlacardDao placardDao;
	@Autowired
	public void setPlacardDao(PlacardDao placardDao) {
		this.placardDao = placardDao;
	}

	@Override
	public int addPlacard(Placard placard) {
		// TODO Auto-generated method stub
		try {
			return placardDao.addPlacard(placard);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updatePlacard(Placard placard) {
		// TODO Auto-generated method stub
		try {
			return placardDao.updatePlacard(placard);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deletePlacard(int id) {
		// TODO Auto-generated method stub
		try {
			return placardDao.deletePlacard(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Placard> queryAllPlacard() {
		// TODO Auto-generated method stub
		try {
			return placardDao.queryAllPlacard();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Placard queryPlacardById(int id) {
		// TODO Auto-generated method stub
		try {
			return placardDao.queryPlacardById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
