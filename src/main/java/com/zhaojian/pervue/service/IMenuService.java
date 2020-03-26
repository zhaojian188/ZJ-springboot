package com.zhaojian.pervue.service;

import com.zhaojian.pervue.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ZJ
 * @since 2020-03-03
 */
public interface IMenuService extends IService<Menu> {
    /**
     * 查询所有的结果
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
