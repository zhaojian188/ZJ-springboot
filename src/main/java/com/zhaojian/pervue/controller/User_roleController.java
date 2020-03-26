package com.zhaojian.pervue.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhaojian.pervue.entity.User_role;
import com.zhaojian.pervue.service.IUser_roleService;
import com.zhaojian.pervue.vo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ZJ
 * @since 2020-03-03
 */
@RestController
@RequestMapping("/user_role")
public class User_roleController {
    @Autowired
    private IUser_roleService iUser_roleService;

    @RequestMapping("/insert")
    public ResultEntity insert(Integer uid, Integer rids[]){
        //先删除用户角色里面的所有角色
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("uid",uid);
        //执行删除角色的方法
        iUser_roleService.remove(queryWrapper);
        //在执行保存
        if(rids!=null && rids.length>0){
            //创建集合进行批量保存用户角色
            List<User_role> entityList = new ArrayList<>();
            //foreach循环遍历角色的id
            for(Integer rid:rids) {
                //创建用户角色对象
                User_role user_role = new User_role();
                //设置用户的id值
                user_role.setUid(uid);
                //设置用户的角色id值
                user_role.setRid(rid);
                //加入到集合中
                entityList.add(user_role);
            }
            iUser_roleService.saveBatch(entityList);
        }
        //返回结果
        return ResultEntity.ok(true);
    }

}

