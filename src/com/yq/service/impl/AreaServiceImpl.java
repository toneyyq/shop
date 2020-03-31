package com.yq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yq.dao.AreaDao;
import com.yq.po.Area;
import com.yq.service.AreaService;
@Service("areaService")
public class AreaServiceImpl implements AreaService {
	private AreaDao areaDao;
	@Autowired
	public void setAreaDao(AreaDao areaDao) {
		this.areaDao = areaDao;
	}
	@Override
	public List<Area> queryAllAreaByCityCode(String cityCode) {
		// TODO Auto-generated method stub
		try {
			return areaDao.queryAllAreaByCityCode(cityCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Area queryAreaByAreaCode(String areaCode) {
		// TODO Auto-generated method stub
		try {
			return areaDao.queryAreaByAreaCode(areaCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	

}
