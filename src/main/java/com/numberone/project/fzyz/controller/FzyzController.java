package com.numberone.project.fzyz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 模态窗口
 * 
 * @author numberone
 */
@Controller
@RequestMapping("/fzyz")
public class FzyzController
{
    private String prefix = "fzyz";

    /**
     * 模态窗口
     */
    @GetMapping("/index")
    public String index()
    {
        return prefix + "/index";
    }

    /**
     * 模态窗口
     */
    @GetMapping("/header")
    public String header()
    {
        return prefix + "/header";
    }


}
