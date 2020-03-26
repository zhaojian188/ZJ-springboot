package com.zhaojian.pervue.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhaojian.pervue.entity.Role;
import com.zhaojian.pervue.entity.RoleVo;
import com.zhaojian.pervue.service.IMenu_roleService;
import com.zhaojian.pervue.service.IRoleService;
import com.zhaojian.pervue.vo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ZJ
 * @since 2020-03-03
 */
//一定要记住注解写RestController，因为他返回的是json串
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService iRoleService;

    @Autowired
    private IMenu_roleService iMenu_roleService;

    @RequestMapping("/list")
    public ResultEntity list() {
        return ResultEntity.ok(iRoleService.list());
    }

    @RequestMapping("/select")
    public ResultEntity select(@RequestParam(defaultValue ="1") long current, @RequestParam(defaultValue ="3")long size,
                               RoleVo roleVo){
        //1.创建分页对象
        Page page = new Page(current, size);
        //2.执行分页查询
        IPage<RoleVo> pageInfo = iRoleService.selectPageVo(page, roleVo);
        //3.执行返回结果
        return ResultEntity.ok(pageInfo);
    }

    @RequestMapping("/deletes")
    public ResultEntity deletes(Integer ids[]) {
        //首先删除管理的表
        for (Integer id : ids) {
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("rid",id);
            iMenu_roleService.remove(wrapper);
        }
        //再去删除主表

        //批量删除
        boolean flag = iRoleService.removeByIds(Arrays.asList(ids));
        //定义返回结果
        return ResultEntity.ok(flag);
    }

    /*@RequestMapping("/getById")
    public ResultEntity getById(Integer id){
        Role role = iRoleService.getById(id);
        return ResultEntity.ok(role);
    }*/

    @RequestMapping("/update")
    public ResultEntity update(@RequestBody Role role) {
        boolean flag = iRoleService.updateById(role);
        return ResultEntity.ok(flag);
    }



}

