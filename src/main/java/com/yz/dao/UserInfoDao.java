package com.yz.dao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

import com.yz.domain.DO.UserInfoDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author yz
 * @email admin@getto1.com
 * @date 2021-07-13 11:04:01
 */
@Mapper
public interface UserInfoDao {

	UserInfoDO get(Integer id);

	List<UserInfoDO> getByOpenId(@Param("openId")String openId);

	List<UserInfoDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(UserInfoDO userInfo);
	
	int update(UserInfoDO userInfo);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
