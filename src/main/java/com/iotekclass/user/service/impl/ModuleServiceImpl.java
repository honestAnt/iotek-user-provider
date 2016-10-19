package com.iotekclass.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.iotekclass.user.mapper.ModuleMapper;
import com.iotekclass.model.user.ModuleInfo;
import com.iotekclass.service.user.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = "1.0.0")
public class ModuleServiceImpl implements ModuleService {
	@Autowired
	private ModuleMapper moduleMapper;

	/**
	 * 获取角色模块
	 * @param userId
	 * @return
	 */
	public List<ModuleInfo> findModuleByUserId(int userId) {
		return moduleMapper.findModuleByUserId(userId);
	}
}
