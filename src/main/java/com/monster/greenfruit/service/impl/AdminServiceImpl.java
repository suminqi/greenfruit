package com.monster.greenfruit.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.monster.greenfruit.dao.AdminMapper;
import com.monster.greenfruit.pojo.domain.Admin;
import com.monster.greenfruit.pojo.dto.AdminDTO;
import com.monster.greenfruit.service.AdminSevice;
import com.monster.greenfruit.service.exception.FrontException;
import com.monster.greenfruit.service.exception.GreenFruitNullException;
import com.monster.greenfruit.service.exception.GreenFruitServerException;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotBlank;
import java.util.List;


/**
 * Developed by Mingkey Su
 * 2020/02/25
 */

@Service
@Transactional(rollbackFor = {GreenFruitServerException.class})
public class AdminServiceImpl implements AdminSevice {

    private final String ENCRYPTION_TYPE = "MD5";

    private final int HASH_TIMES = 1024;


    @Autowired
    AdminMapper adminMapper;

    private static Logger adminLog = LoggerFactory.getLogger("admin");


    @Override
    public String updatePwd(@NotBlank(message = "旧密码不能为空") String oldPwd,
                            @NotBlank(message = "新密码不能为空") String newPwd,
                            Admin admin) throws FrontException, GreenFruitServerException {

        String toolOldPwd = new SimpleHash(ENCRYPTION_TYPE, oldPwd, admin.getAdminSalt(), HASH_TIMES).toHex();

        if (!admin.getPassword().equals(toolOldPwd)) {
            throw new FrontException("密码错误，请重试");
        }

        String toolNewPwd = new SimpleHash(ENCRYPTION_TYPE, newPwd, admin.getAdminSalt(), HASH_TIMES).toHex();

        admin.setPassword(toolNewPwd);

        int rows = adminMapper.updateByPrimaryKey(admin);

        if (rows != 1) {
            throw new GreenFruitServerException("修改失败，系统错误");
        }

        return "修改成功";

    }


    @Override
    public PageInfo<Admin> selectAllAdmin(Integer page, Integer limit)
            throws GreenFruitNullException {

        if (page == null || limit == null) {
            throw new GreenFruitNullException("页号或页码不能为空");
        }

        PageHelper.startPage(page, limit);

        return new PageInfo<>(adminMapper.selectAll());
    }


    @Override
    public int delAdminByAdminId(Long adminId) throws GreenFruitServerException {

        int row = adminMapper.deleteByPrimaryKey(adminId);

        if (row != 1) {
            throw new GreenFruitServerException("删除失败");
        }
        return row;
    }

    @Override
    public int addAdmin(Admin admin) throws GreenFruitServerException {

        String password = new SimpleHash(ENCRYPTION_TYPE, admin.getPassword(),
                admin.getAdminSalt(), HASH_TIMES).toHex();

        String adminIdentity = new SimpleHash(ENCRYPTION_TYPE, admin.getAdminIdentity(),
                admin.getAdminSalt(), HASH_TIMES).toHex();

        admin.setPassword(password);

        admin.setAdminIdentity(adminIdentity);

        int row = adminMapper.insert(admin);


        adminLog.info("{}", "管理员id: " + admin.getAdminId() + " 管理员名: " + admin.getAdminName() + " 被添加为管理员");


        return row;
    }


    @Override
    public Admin selectByParam(String adminParam) {


        if (adminParam.length() == 11) {
            return adminMapper.selectByCellphone(adminParam);
        } else if (adminParam.length() >= 5 && adminParam.length() < 11) {
            return adminMapper.selectByPrimaryKey(Long.parseLong(adminParam));
        }
        return null;
    }

    @Override
    public PageInfo<Admin> searchAdmin(Integer page, Integer limit, AdminDTO adminDTO) {

        PageHelper.startPage(page,limit);

        List<Admin> admins=adminMapper.searchAdmin(adminDTO.getAdminId(),adminDTO.getAdminName(),
                adminDTO.getAdminCellphone(),adminDTO.getLevel());

        return new PageInfo<>(admins);
    }

}
