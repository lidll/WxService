package com.yz.domain.DO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author yz
 * @email admin@getto1.com
 * @date 2021-07-13 11:04:01
 */
@Data
@NoArgsConstructor
public class UserInfoDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//用户openId
	private String openId;
	//创建时间
	private Date createDate;
	//更新时间
	private Date updateDate;
	//备注
	private String remark;
	//用户名
	private String userName;
	//密码
	private String passWord;
	//手机号
	private String mobile;

	public UserInfoDO(String openId){
		Date date = new Date();
		this.createDate = date;
		this.updateDate = date;
		this.openId = openId;
	}

}
