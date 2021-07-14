package com.yz.service;


import com.yz.domain.DO.UserInfoDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author yz
 * @email admin@getto1.com
 * @date 2021-07-13 11:04:01
 */
public interface UserInfoService {
	
	UserInfoDO get(Integer id);

	List<UserInfoDO> getByOpenId(String openId);

	List<UserInfoDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UserInfoDO userInfo);
	
	int update(UserInfoDO userInfo);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
