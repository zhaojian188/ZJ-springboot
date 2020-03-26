package com.zhaojian.pervue.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class NationVo implements Serializable {

    //对应三级联动的id值 id ，cid,did
    private Integer value;

    //对应三级联动的名称：province，city ,district
    private String label;

    private List<NationVo> children;
}
