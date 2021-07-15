package com.yz.dao;

import com.yz.domain.DO.DishInfoDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author yz
 * @email admin@getto1.com
 * @date 2021-07-14 17:07:55
 */
@Mapper
public interface DishInfoDao {

	DishInfoDO get(Integer id);
	
	List<DishInfoDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(DishInfoDO dishInfo);
	
	int update(DishInfoDO dishInfo);
	
	int remove(Integer id);

	int removeByName(@Param("name")String name);

	int batchRemove(Integer[] ids);
}
