package com.zhaojian.pervue.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhaojian.pervue.entity.Goods_sales;
import com.zhaojian.pervue.entity.User_role;
import com.zhaojian.pervue.service.IGoods_salesService;
import com.zhaojian.pervue.vo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ZJ
 * @since 2020-03-14
 */
@RestController
@RequestMapping("/goods_sales")
public class Goods_salesController {
    @Autowired
    private IGoods_salesService iGoods_salesService;

    @RequestMapping("/insert")
    public ResultEntity insert(Integer gid, Integer sids[]){
        //先删除用户角色里面的所有角色
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("gid",gid);
        //执行删除角色的方法
        iGoods_salesService.remove(queryWrapper);
        //在执行保存
        if(sids!=null && sids.length>0){
            //创建集合进行批量保存用户角色
            List<Goods_sales> entityList = new ArrayList<>();
            //foreach循环遍历角色的id
            for(Integer sid:sids) {
                //创建用户角色对象
                Goods_sales goods_sales = new Goods_sales();
                //设置用户的id值
                goods_sales.setGid(gid);
                //设置用户的角色id值
                goods_sales.setSid(sid);
                //加入到集合中
                entityList.add(goods_sales);
            }
            iGoods_salesService.saveBatch(entityList);
        }
        //返回结果
        return ResultEntity.ok(true);
    }

}

