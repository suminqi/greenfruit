package com.monster.greenfruit.service;

import com.monster.greenfruit.service.exception.GreenFruitServerException;


/**
 * Developed by Mingkey Su
 * 2020/02/25
 */
public interface OrderManageService {

    int addAdmin(Long adminId, String adminName) throws GreenFruitServerException;

    int delAdmin(Long adminId) throws GreenFruitServerException;

    int countOrderManage();


}
