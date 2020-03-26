package com.zhaojian.pervue.entity;

import lombok.Data;

/**
 * 扩展省市县的类，用于做三级联动前台数据的显示
 */
@Data
public class UserVo extends User  {
    //省
    private String provinceName;
    //市
    private String cityName;
    //县
    private String districtName;

    //扩展的角色属性
    private String rids;
    private String rnames;
    private String rnameZhs;
}
