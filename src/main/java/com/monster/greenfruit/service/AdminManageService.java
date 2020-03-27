package com.monster.greenfruit.service;

import com.monster.greenfruit.pojo.domain.AdminManage;
import com.monster.greenfruit.service.exception.GreenFruitServerException;
import com.monster.greenfruit.service.exception.InsufficientAuthorityException;


/**
 * Developed by Mingkey Su
 * 2020/02/25
 */
public interface AdminManageService {

//    AdminManage hasAuthority(Long adminId) throws InsufficientAuthorityException;

    int addAdmin(Long adminId, String adminName) throws GreenFruitServerException;

    int delAdmin(Long adminId) throws GreenFruitServerException;

    int countAdminManage();

}
