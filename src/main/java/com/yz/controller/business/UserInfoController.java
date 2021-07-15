//package com.yz.controller.business;
//
//import java.util.List;
//import java.util.Map;
//
//import com.yz.domain.DO.UserInfoDO;
//import com.yz.domain.dto.ResponseDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.yz.service.UserInfoService;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// *
// *
// * @author yz
// * @email admin@getto1.com
// * @date 2021-07-13 11:04:01
// */
//
//@RestController
//@RequestMapping("/yz/userInfo")
//public class UserInfoController {
//	@Autowired
//	private UserInfoService userInfoService;
//
//	@GetMapping()
//	String UserInfo(){
//	    return "yz/userInfo/userInfo";
//	}
//
//	@GetMapping("/list")
//	public ResponseDto list(@RequestParam Map<String, Object> params){
//		//查询列表数据
//		List<UserInfoDO> userInfoList = userInfoService.list(null);
//		int total = userInfoService.count(null);
//		return ResponseDto.construct(userInfoList,total);
//	}
//}
