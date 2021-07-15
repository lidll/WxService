package com.yz.service.impl;

import com.yz.service.CommandStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.yz.dao.DishInfoDao;
import com.yz.domain.DO.DishInfoDO;
import com.yz.service.DishInfoService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class DishInfoServiceImpl implements DishInfoService {
	@Autowired
	private DishInfoDao dishInfoDao;
	
	@Override
	public DishInfoDO get(Integer id){
		return dishInfoDao.get(id);
	}
	
	@Override
	public List<DishInfoDO> list(Map<String, Object> map){
		return dishInfoDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return dishInfoDao.count(map);
	}
	
	@Override
	public int save(DishInfoDO dishInfo){
		return dishInfoDao.save(dishInfo);
	}
	
	@Override
	public int update(DishInfoDO dishInfo){
		return dishInfoDao.update(dishInfo);
	}

	@Override
	public int remove(Integer id){
		return dishInfoDao.remove(id);
	}

	@Override
	public int removeByName(String name) {
		return dishInfoDao.removeByName(name);
	}

	@Override
	public int batchRemove(Integer[] ids){
		return dishInfoDao.batchRemove(ids);
	}

}
