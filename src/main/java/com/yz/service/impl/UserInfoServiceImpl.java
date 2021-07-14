package com.yz.service.impl;

import com.yz.domain.DO.UserInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.yz.dao.UserInfoDao;
import com.yz.service.UserInfoService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoDao userInfoDao;
	
	@Override
	public UserInfoDO get(Integer id){
		return userInfoDao.get(id);
	}

	@Override
	public List<UserInfoDO> getByOpenId(String openId) {
		return userInfoDao.getByOpenId(openId);
	}

	@Override
	public List<UserInfoDO> list(Map<String, Object> map){
		return userInfoDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return userInfoDao.count(map);
	}
	
	@Override
	public int save(UserInfoDO userInfo){
		return userInfoDao.save(userInfo);
	}
	
	@Override
	public int update(UserInfoDO userInfo){
		return userInfoDao.update(userInfo);
	}
	
	@Override
	public int remove(Integer id){
		return userInfoDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return userInfoDao.batchRemove(ids);
	}
	
}
