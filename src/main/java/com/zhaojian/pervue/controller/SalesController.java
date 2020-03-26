package com.zhaojian.pervue.controller;


import com.zhaojian.pervue.service.ISalesService;
import com.zhaojian.pervue.vo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ZJ
 * @since 2020-03-14
 */
@RestController
@RequestMapping("/sales")
public class SalesController {
    @Autowired
    private ISalesService iSalesService;

    /**
     * 促销活动查询
     * @return
     */
    @RequestMapping("list")
    public ResultEntity list(){
        return ResultEntity.ok(iSalesService.list());
    }


}

