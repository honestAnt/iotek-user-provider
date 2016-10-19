package com.iotekclass.user.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.iotekclass.user.mapper.UserMapper;
import com.iotekclass.model.user.ModuleInfo;
import com.iotekclass.model.user.UserInfo;
import com.iotekclass.service.user.ModuleService;
import com.iotekclass.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Reference(version = "1.0.0")
	private ModuleService moduleService;

	/**
	 * 根据账号Account查询当前用户
	 * @param account
	 * @return
	 */
	public UserInfo findByAccount(String account) {
		return userMapper.findByAccount(account);
	}

	/**
	 * 获取资源集合
	 * @param account
	 * @return
	 */
	public Set<String> findPermissions(String account) {
		Set<String> set = Sets.newHashSet();
		UserInfo user = findByAccount(account);
		List<ModuleInfo>modules = moduleService.findModuleByUserId(user.getId());
		
		for(ModuleInfo info: modules) {
			set.add(info.getModuleKey());
		}
		return set;
	}

	/**
	 * 获取URL权限
	 * @param account
	 * @return
	 */
	public List<String> findPermissionUrl(String account) {
		List<String> list = Lists.newArrayList();
		UserInfo user = findByAccount(account);
		List<ModuleInfo>modules = moduleService.findModuleByUserId(user.getId());
		
		for(ModuleInfo info: modules) {
			if(info.getModuleType() == ModuleInfo.URL_TYPE) {
				list.add(info.getModulePath());
			}
		}
		return list;
	}
}