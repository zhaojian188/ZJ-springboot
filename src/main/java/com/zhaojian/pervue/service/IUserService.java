package com.zhaojian.pervue.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhaojian.pervue.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhaojian.pervue.entity.UserVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ZJ
 * @since 2020-03-03
 */
public interface IUserService extends IService<User> {
    /**
     * 分页对象，xml中可以从里面进行取值，传递参数Page
     * @param page
     * @param userVo
     * @return
     */
    IPage<User> selectPageVo(Page<?> page, UserVo userVo);
}
