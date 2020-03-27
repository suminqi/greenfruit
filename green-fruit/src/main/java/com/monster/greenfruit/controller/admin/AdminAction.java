package com.monster.greenfruit.controller.admin;


import com.monster.greenfruit.pojo.domain.Admin;
import com.monster.greenfruit.pojo.vo.CountAdminVO;
import com.monster.greenfruit.service.*;
import com.monster.greenfruit.service.exception.AccountFormatException;
import com.monster.greenfruit.service.exception.FrontException;
import com.monster.greenfruit.service.exception.GreenFruitServerException;
import com.monster.greenfruit.utils.utilsclass.ToolMessage;
import com.monster.greenfruit.pojo.dto.MessageBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * Developed by Mingkey Su
 * 2020/02/25
 */
@Controller
@RequestMapping(value = "/greenfruit/admin/admin")
public class AdminAction {

    @Autowired
    private AdminSevice adminSevice;
    @Autowired
    private AdminManageService adminManageService;
    @Autowired
    private ActivitySetService activitySetService;
    @Autowired
    private OrderManageService orderManageService;
    @Autowired
    private UsrManageService usrManageService;

    private static Logger adminLog = LoggerFactory.getLogger("admin");


    @GetMapping(value = "/page/login")
    public String getLoginPage() {
        return "login";
    }


    @GetMapping(value = "/page/welcome")
    public String getWelcomePage() {
        return "welcome";
    }


    @GetMapping(value = "/page/echarts")
    public String getEchartOnePage() {
        return "echarts";
    }

    @GetMapping(value = "/page/city")
    public String getCityPage(){
        return "city";
    }


    @GetMapping(value = "/page/updatePwd")
    public String getUpdatePwdPage() {
        return "admin-updatePwd";
    }


    @GetMapping(value = "/page/index")
    public String getIndexPage(Model model) {
        Admin admin = (Admin) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("admin", admin);
        return "index";
    }

    @GetMapping(value = "/countAllAdmin.action")
    public @ResponseBody
    MessageBean countAllAdmin(){
        CountAdminVO countAdminVO = new CountAdminVO();

        countAdminVO.setActivitySet(activitySetService.countActivitySet());
        countAdminVO.setAdminManage(adminManageService.countAdminManage());
        countAdminVO.setOrderManage(orderManageService.countOrderManage());
        countAdminVO.setUsrManage(usrManageService.countUsrManage());

        return ToolMessage.success(countAdminVO);
    }

    @PostMapping(value = "/login.action")
    public @ResponseBody
    MessageBean loginByPwd(@RequestParam String adminParam, @RequestParam String password)
            throws UnknownAccountException, IncorrectCredentialsException, AccountFormatException {

        Subject subject = SecurityUtils.getSubject();

        for (char chr : adminParam.toCharArray()) {

            if (chr < 48 || chr > 57) {
                throw new AccountFormatException("请输入正确的账号格式噢~");
            }
        }

        UsernamePasswordToken token = new UsernamePasswordToken(adminParam, password);

        subject.login(token);

        return ToolMessage.success("登陆成功");
    }


    @PutMapping(value = "/updatePwd.action")
    public @ResponseBody
    MessageBean updatePwdByOld(@RequestParam String oldPwd,
                               @RequestParam String newPwd)
            throws FrontException, GreenFruitServerException {

        Admin admin = (Admin) SecurityUtils.getSubject().getPrincipal();

        adminSevice.updatePwd(oldPwd, newPwd, admin);

        return ToolMessage.success("修改成功");
    }


    @GetMapping(value = "/logout.action")
    public MessageBean logout() {

        Subject subject = SecurityUtils.getSubject();

        subject.logout();

        return ToolMessage.success("退出成功");

    }



}
