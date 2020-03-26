package com.zhaojian.pervue.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhaojian.pervue.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhaojian.pervue.entity.UserVo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ZJ
 * @since 2020-03-03
 */
public interface UserMapper extends BaseMapper<User> {

    IPage<User> selectPageVo(Page<?> page, UserVo userVo);
}
