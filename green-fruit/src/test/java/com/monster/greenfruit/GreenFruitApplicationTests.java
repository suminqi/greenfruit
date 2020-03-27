package com.monster.greenfruit;

import com.monster.greenfruit.dao.AdminMapper;
import com.monster.greenfruit.pojo.domain.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GreenFruitApplicationTests {

    @Autowired
    AdminMapper adminMapper;

    @Test
    void contextLoads() {
    }


    @Test
    public void test() {


        List<Admin> admins = adminMapper.selectAll();


        for (Admin admin : admins) {
            System.out.println(admin.toString());
        }


    }

}
