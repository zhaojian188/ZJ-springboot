package com.zhaojian.pervue.controller;


import com.zhaojian.pervue.service.INationService;
import com.zhaojian.pervue.vo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 城市字典表 前端控制器
 * </p>
 *
 * @author ZJ
 * @since 2020-03-03
 */
@RestController
@RequestMapping("/nation")
public class NationController {

    @Autowired
    private INationService iNationService;

    /**
     * 三级联动城市查询
     * @return
     */
    @RequestMapping("/list")
    public ResultEntity findAllCity() {
        return ResultEntity.ok(iNationService.findAllCity());
    }

}

