package com.yz.domain.DO;

import com.yz.constant.EatWhatCon;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author yz
 * @email admin@getto1.com
 * @date 2021-07-14 17:07:55
 */
@Data
@NoArgsConstructor
public class DishInfoDO implements Serializable {
	private static final long serialVersionUID = 1L;
	//
	private Integer id;
	//菜名
	private String name;
	//类型 1早餐 2中餐 3晚餐
	private Integer type;
	//
	private Date createDate;
	//
	private String createBy;

	public DishInfoDO(String name){
		this.createDate = new Date();
		this.type = EatWhatCon.DISH_TYPE_OTHER;
		this.name = name;
	}
}
