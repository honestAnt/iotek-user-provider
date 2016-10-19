package com.iotekclass.user.mapper;

import com.iotekclass.common.BaseMapper;
import com.iotekclass.model.user.UserInfo;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<UserInfo> {

	@Select("select * from tb_user where username=#{account}")
	UserInfo findByAccount(String account);

	UserInfo getByName(String username);
}
