package com.monster.greenfruit.controller.admin;


import com.github.pagehelper.PageInfo;
import com.monster.greenfruit.pojo.domain.Admin;
import com.monster.greenfruit.service.*;
import com.monster.greenfruit.service.exception.GreenFruitNullException;
import com.monster.greenfruit.service.exception.GreenFruitServerException;
import com.monster.greenfruit.service.exception.InsufficientAuthorityException;
import com.monster.greenfruit.pojo.dto.AdminDTO;
import com.monster.greenfruit.service.exception.PhoneRegisteredException;
import com.monster.greenfruit.utils.utilsclass.ToolMessage;
import com.monster.greenfruit.pojo.dto.MessageBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.UUID;


/**
 * Developed by Mingkey Su
 * 2020/02/25
 */
@Controller
@RequestMapping(value = "/greenfruit/admin/power")
@Transactional(rollbackFor = {PhoneRegisteredException.class})
public class AdminPowerAction {

    @Autowired
    AdminSevice adminSevice;

    @Autowired
    AdminManageService adminManageService;

    @Autowired
    ActivitySetService activitySetService;

    @Autowired
    OrderManageService orderManageService;

    @Autowired
    UsrManageService usrManageService;

    @Autowired
    AdminPermsService adminPermsService;


    private static Logger adminLog = LoggerFactory.getLogger("admin");


    private void selectRole(Integer level, Long adminId, String adminName) throws GreenFruitServerException {


        adminLog.info("{}", "管理员id: " + adminId + " 管理员名: " + adminName + " 被添加为 " + level + " 级管理员");


        if (level == 4) {
            adminManageService.addAdmin(adminId, adminName);
        } else if (level == 3) {
            activitySetService.addAdmin(adminId, adminName);
        } else if (level == 2) {
            orderManageService.addAdmin(adminId, adminName);
        } else {
            usrManageService.addAdmin(adminId, adminName);
        }
    }

    private void delRole(Integer level, Long adminId) throws GreenFruitServerException {

        adminLog.info("{}", "管理员id: " + adminId + " 管理员ID: " + adminId + " 被删除");

        if (level == 4) {
            adminManageService.delAdmin(adminId);
        } else if (level == 3) {
            activitySetService.delAdmin(adminId);
        } else if (level == 2) {
            orderManageService.delAdmin(adminId);
        } else {
            usrManageService.delAdmin(adminId);
        }

    }

    private void setAdminRoles(Integer level, Long adminId,String perms){

        String[] roles={"usr_manage","order_manage","activity_set","admin_manage"};
        adminPermsService.insertAdminPerms(adminId, perms, roles[level-1]);
    }

    // 判断手机号是否已注册
    private boolean phoneExit(String adminParam) throws PhoneRegisteredException {
        Admin admin = adminSevice.selectByParam(adminParam);
        if(admin!=null)
            throw new PhoneRegisteredException("手机号已被注册");
        return false;
    }


    @GetMapping(value = "/page/adminList")
    public String getAdminListPage() {
        return "admin-list";
    }


    @GetMapping(value = "/page/adminRule")
    public String getAdminRulePage() {
        return "admin-rule";
    }


    @GetMapping(value = "/page/adminCate")
    public String getAdminCatePage() {
        return "admin-cate";
    }


    @GetMapping(value = "/page/adminAdd")
    public String getAdminAddPage() {
        return "admin-add";
    }

    @RequestMapping(value = "/unauthorized.action")
    public void unauthorized() throws InsufficientAuthorityException {
        throw new InsufficientAuthorityException("权限不足");
    }


    @GetMapping(value = "/getAdminList.action")
    public @ResponseBody
    MessageBean getAdminList(@NotNull(message = "页号不能为空") Integer page,
                             @NotNull(message = "页面数据量不能为空") Integer limit)
            throws GreenFruitNullException {


        PageInfo<Admin> admins = adminSevice.selectAllAdmin(page, limit);

        return ToolMessage.success(admins);
    }


    @PostMapping(value = "/addAdmin.action")
    public
    @ResponseBody
    MessageBean addAdmin(AdminDTO adminDTO)
            throws GreenFruitServerException, PhoneRegisteredException {

        Admin admin = (Admin) SecurityUtils.getSubject().getPrincipal();

        phoneExit(adminDTO.getAdminCellphone());

        adminDTO.setAdminSalt(UUID.randomUUID().toString());

        Admin newAdmin = new Admin(adminDTO);

        adminSevice.addAdmin(newAdmin);

        adminLog.info("{}", "管理员id: " + admin.getAdminId() + " 管理员名: " + admin.getAdminName()
                + " 将 " + adminDTO.getAdminName() + " 添加为管理员");

        // 根据信息插入对应权限的管理员列表,注意adminDTO中的adminId为空，newAdmin中的adminId有效
        selectRole(adminDTO.getLevel(), newAdmin.getAdminId(), newAdmin.getAdminName());
        setAdminRoles(adminDTO.getLevel(), newAdmin.getAdminId(), adminDTO.getPerms());
        return ToolMessage.success("添加成功");
    }


    @DeleteMapping(value = "/delAdmin.action")
    public @ResponseBody
    MessageBean delAdmin(@RequestParam Long adminId,
                         @RequestParam Integer level)
            throws  GreenFruitServerException, GreenFruitNullException {

        Admin admin = (Admin) SecurityUtils.getSubject().getPrincipal();

        if (admin.getAdminId().equals(adminId)) {
            return ToolMessage.failure("不能删除自己喔~");
        }

        delRole(level, adminId);

        adminPermsService.delAdminPerms(adminId);

        adminSevice.delAdminByAdminId(adminId);

        return ToolMessage.success("删除成功");

    }


    @GetMapping(value = "/searchAdmin.action")
    public @ResponseBody
    MessageBean searchAdmin(Integer page, Integer limit, AdminDTO adminDTO){

        PageInfo<Admin> admins = adminSevice.searchAdmin(page, limit, adminDTO);

        return ToolMessage.success(admins);
    }

}
