package com.monster.greenfruit.service.impl;

import com.monster.greenfruit.dao.UsrManageMapper;
import com.monster.greenfruit.pojo.domain.UsrManage;
import com.monster.greenfruit.service.UsrManageService;
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
public class UsrManageServiceImpl implements UsrManageService {


    @Autowired
    UsrManageMapper usrManageMapper;


    @Override
    public int addAdmin(Long adminId, String adminName) throws GreenFruitServerException {
        UsrManage usrManage = new UsrManage();
        usrManage.setAdminId(adminId);
        usrManage.setAdminName(adminName);


        return usrManageMapper.insert(usrManage);


    }

    @Override
    public int delAdmin(Long adminId) throws GreenFruitServerException {
        int row = usrManageMapper.deleteByPrimaryKey(adminId);
        if (row != 1) {
            throw new GreenFruitServerException("系统错误");
        }
        return row;
    }

    @Override
    public int countUsrManage() {
        return usrManageMapper.countUsrManage();
    }
}
