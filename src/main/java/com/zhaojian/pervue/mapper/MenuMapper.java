package com.zhaojian.pervue.mapper;

import com.zhaojian.pervue.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ZJ
 * @since 2020-03-03
 */
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 查询所有的二级子菜单的结果
     * @return
     */
    List<Menu> listMenus();

    /**
     * 根据用户名称,查询用户对应的menu资源
     * @param userName
     * @return
     */
    List<Menu> listMenusByUserName(String userName);
}
