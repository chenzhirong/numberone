package com.numberone.project.system.user.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.numberone.framework.config.NumberOneConfig;
import com.numberone.framework.web.controller.BaseController;
import com.numberone.project.system.menu.domain.Menu;
import com.numberone.project.system.menu.service.IMenuService;
import com.numberone.project.system.user.domain.User;

/**
 * 首页 业务处理
 * 
 * @author numberone
 */
@Controller
public class IndexController extends BaseController
{
    @Autowired
    private IMenuService menuService;

    @Autowired
    private NumberOneConfig numberOneConfig;

    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap mmap)
    {
        // 取身份信息
        User user = getSysUser();
        // 根据用户id取出菜单
        List<Menu> menus = menuService.selectMenusByUser(user);
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("copyrightYear", numberOneConfig.getCopyrightYear());
        mmap.put("demoEnabled", numberOneConfig.isDemoEnabled());
        return "/index";
    }

    // 系统首页
    @GetMapping("/")
    public String mainPage(ModelMap mmap)
    {
//        // 取身份信息
//        User user = getSysUser();
//        // 根据用户id取出菜单
//        mmap.put("user", user);
//        mmap.put("copyrightYear", numberOneConfig.getCopyrightYear());
//        mmap.put("demoEnabled", numberOneConfig.isDemoEnabled());
        return "fzyz/index";
    }

    // 切换主题
    @GetMapping("/system/switchSkin")
    public String switchSkin(ModelMap mmap)
    {
        return "skin";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap)
    {
        mmap.put("version", numberOneConfig.getVersion());
        return "main";
    }
}
