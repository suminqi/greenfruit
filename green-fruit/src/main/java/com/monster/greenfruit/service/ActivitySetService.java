package com.monster.greenfruit.service;

import com.monster.greenfruit.service.exception.GreenFruitServerException;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Developed by Mingkey Su
 * 2020/02/25
 */

public interface ActivitySetService {


    int addAdmin(Long adminId, String adminName) throws GreenFruitServerException;

    int delAdmin(Long adminId) throws GreenFruitServerException;

    int countActivitySet();

}
