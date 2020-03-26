package com.zhaojian.pervue.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhaojian.pervue.entity.Goods;
import com.zhaojian.pervue.entity.GoodsVo;
import com.zhaojian.pervue.service.IGoodsService;
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
 * @since 2020-03-14
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private IGoodsService iGoodsService;

    @RequestMapping("/list")
    public ResultEntity list(@RequestParam(defaultValue = "1")long current,
                             @RequestParam(defaultValue = "3")long size,
                             GoodsVo goodsVo){
        //声明page对象
        Page page = new Page(current,size);
        //自定义分页查询
        IPage<GoodsVo> pageInfo = iGoodsService.selectPageVo(page,goodsVo);
        return ResultEntity.ok(pageInfo);
    }

    /**
     * 商品添加的方法
     * @param entity
     * @return
     */
    @RequestMapping("/insert")
    public ResultEntity insert(@RequestBody Goods entity) {
        boolean flag = iGoodsService.save(entity);
        return ResultEntity.ok(flag);
    }

    /**
     * 删除商品
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public ResultEntity delete(Integer ids[]){
        boolean flag = iGoodsService.removeByIds(Arrays.asList(ids));
        return ResultEntity.ok(flag);
    }

    /**
     * 用户编辑的方法
     * @param entity
     * @return
     */
    @RequestMapping("/update")
    public ResultEntity update(@RequestBody Goods entity) {
        boolean flag = iGoodsService.updateById(entity);
        return ResultEntity.ok(flag);
    }


}

