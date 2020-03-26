package com.zhaojian.pervue.controller;


import com.zhaojian.pervue.entity.User;
import com.zhaojian.pervue.service.IMenuService;
import com.zhaojian.pervue.vo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ZJ
 * @since 2020-03-03
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private IMenuService iMenuService;

    /**
     * 子菜单列表
     * @return
     */
    @RequestMapping("/list")
    public ResultEntity list() {
        return ResultEntity.ok(iMenuService.listMenus());
    }

    /**
     * 根据用户，查询用户对应的菜单功能
     * @RequestParam(defaultValue = "lisi")中的defaultValue这个值可以省略不写，因为从session作用域共享，不需要加默认值了
     * @param request
     * @param userName
     * @return
     */
    @RequestMapping("/listByUserName")
    public ResultEntity listByUserName(HttpServletRequest request,
            @RequestParam(defaultValue = "lisi")String userName) {
        System.out.println(request.getSession().getId()+"=============");
        //获取session中存的值
        User user= (User)request.getSession().getAttribute("user");
        //判断session中的值是否是空
        if(user!=null){
            //登录的用户
            userName = user.getUsername();
            System.out.println("+++++++++++"+userName);
        }
        return ResultEntity.ok(iMenuService.listMenusByUserName(userName));
    }




}

