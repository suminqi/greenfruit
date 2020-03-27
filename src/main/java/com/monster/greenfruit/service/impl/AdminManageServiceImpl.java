package com.monster.greenfruit.service.impl;

import com.monster.greenfruit.dao.AdminManageMapper;
import com.monster.greenfruit.pojo.domain.AdminManage;
import com.monster.greenfruit.service.AdminManageService;
import com.monster.greenfruit.service.exception.GreenFruitServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Developed by Mingkey Su
 * 2020/02/25
 */

@Service
@Transactional(rollbackFor = {GreenFruitServerException.class})
public class AdminManageServiceImpl implements AdminManageService {


    @Autowired
    AdminManageMapper adminManageMapper;



    @Override
    public int addAdmin(Long adminId, String adminName) throws GreenFruitServerException {
        AdminManage adminManage = new AdminManage();
        adminManage.setAdminId(adminId);
        adminManage.setAdminName(adminName);
        return adminManageMapper.insert(adminManage);
    }

    @Override
    public int delAdmin(Long adminId) throws GreenFruitServerException {

        int row = adminManageMapper.deleteByPrimaryKey(adminId);

        if (row != 1) {
            throw new GreenFruitServerException("系统错误");
        }

        return row;


    }

    @Override
    public int countAdminManage() {
        return adminManageMapper.countAdminManage();
    }


}
