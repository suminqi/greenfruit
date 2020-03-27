package com.monster.greenfruit.service.impl;

import com.monster.greenfruit.dao.OrderManageMapper;
import com.monster.greenfruit.pojo.domain.OrderManage;
import com.monster.greenfruit.service.OrderManageService;
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
public class OrderManageServiceImpl implements OrderManageService {

    @Autowired
    OrderManageMapper orderManageMapper;


    @Override
    public int addAdmin(Long adminId, String adminName) throws GreenFruitServerException {

        OrderManage orderManage = new OrderManage();
        orderManage.setAdminId(adminId);
        orderManage.setAdminName(adminName);
        return orderManageMapper.insert(orderManage);


    }

    @Override
    public int delAdmin(Long adminId) throws GreenFruitServerException {
        int row = orderManageMapper.deleteByPrimaryKey(adminId);

        if (row != 1) {
            throw new GreenFruitServerException("系统错误");
        }

        return row;
    }

    @Override
    public int countOrderManage() {
        return orderManageMapper.countOrderManage();
    }
}
