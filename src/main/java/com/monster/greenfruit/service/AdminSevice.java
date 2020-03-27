package com.monster.greenfruit.service;

import com.github.pagehelper.PageInfo;
import com.monster.greenfruit.pojo.domain.Admin;
import com.monster.greenfruit.pojo.dto.AdminDTO;
import com.monster.greenfruit.service.exception.FrontException;
import com.monster.greenfruit.service.exception.GreenFruitNullException;
import com.monster.greenfruit.service.exception.GreenFruitServerException;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * Developed by Mingkey Su
 * 2020/02/25
 */

public interface AdminSevice {

    String updatePwd(@NotBlank(message = "旧密码不能为空") String oldPwd,
                     @NotBlank(message = "新密码不能为空") String newPwd,
                     Admin admin)
            throws FrontException, GreenFruitServerException;


    PageInfo<Admin> selectAllAdmin(@NotNull(message = "页号不能为空") Integer page,
                                   @NotNull(message = "页面数据量不能为空") Integer limit) throws GreenFruitNullException;


    int delAdminByAdminId(Long adminId) throws GreenFruitNullException, GreenFruitServerException;

    int addAdmin(Admin admin) throws GreenFruitServerException;


    Admin selectByParam(@NotNull(message = "手机号或ID不能为空") String adminParam);

    PageInfo<Admin> searchAdmin(Integer page, Integer limit, AdminDTO adminDto);



//    int updateInfo();

}
