package com.monster.greenfruit.service;

import com.monster.greenfruit.pojo.domain.AdminPerms;

public interface AdminPermsService {

	AdminPerms getAdminPermsByAdminId(Long adminId);

	int insertAdminPerms(Long adminId, String perms, String adminRole);

	int delAdminPerms(Long adminId);

}
