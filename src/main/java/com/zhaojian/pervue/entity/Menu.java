package com.zhaojian.pervue.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ZJ
 * @since 2020-03-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Menu implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String url;

    private String path;

    private String component;

    private String name;
    @TableField("iconCls")
    private String iconCls;
    @TableField("keepAlive")
    private Boolean keepAlive;
    @TableField("requireAuth")
    private Boolean requireAuth;
    @TableField("parentId")
    private Integer parentId;

    private Boolean enabled;

    private LocalDateTime create_time;

    //子菜单  这个字段是不存在的
    @TableField(exist = false)
    private List<Menu> menus;


}
