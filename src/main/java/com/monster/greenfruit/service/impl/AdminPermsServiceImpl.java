package com.monster.greenfruit.service.impl;

import com.monster.greenfruit.dao.AdminPermsMapper;
import com.monster.greenfruit.pojo.domain.AdminPerms;
import com.monster.greenfruit.service.AdminPermsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminPermsServiceImpl implements AdminPermsService {

	@Autowired
	AdminPermsMapper adminPermsMapper;

	@Override
	public AdminPerms getAdminPermsByAdminId(Long adminId) {

		AdminPerms adminPerms = adminPermsMapper.selectByPrimaryKey(adminId);

		return adminPerms;
	}

	@Override
	public int insertAdminPerms(Long adminId, String perms, String adminRole) {
		return adminPermsMapper.insert(new AdminPerms(adminId,perms,adminRole));
	}

	@Override
	public int delAdminPerms(Long adminId) {
		return adminPermsMapper.deleteByPrimaryKey(adminId);
	}
}
