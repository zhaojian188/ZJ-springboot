package com.zhaojian.pervue.entity;

import lombok.Data;

@Data
public class GoodsVo extends Goods {
    //省
    private String provinceName;
    //市
    private String cityName;
    //县
    private String districtName;

    //扩展区间查询
    private Double p1;
    private Double p2;


    //扩展的角色属性
    private String sids;
    private String snames;
}
