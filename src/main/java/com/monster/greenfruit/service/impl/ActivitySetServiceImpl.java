package com.monster.greenfruit.service.impl;

import com.monster.greenfruit.dao.ActivitySetMapper;
import com.monster.greenfruit.pojo.domain.ActivitySet;
import com.monster.greenfruit.service.ActivitySetService;
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
public class ActivitySetServiceImpl implements ActivitySetService {


    @Autowired
    ActivitySetMapper activitySetMapper;


    @Override
    public int addAdmin(Long adminId, String adminName) throws GreenFruitServerException {

        ActivitySet activitySet = new ActivitySet();
        activitySet.setAdminId(adminId);
        activitySet.setAdminName(adminName);

        return activitySetMapper.insert(activitySet);

    }

    @Override
    public int delAdmin(Long adminId) throws GreenFruitServerException {

        int row = activitySetMapper.deleteByPrimaryKey(adminId);

        if (row != 1) {
            throw new GreenFruitServerException("系统错误");
        }

        return row;

    }

    @Override
    public int countActivitySet() {
        return activitySetMapper.countActivitySet();
    }
}
