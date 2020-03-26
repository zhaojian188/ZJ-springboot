package com.zhaojian.pervue.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhaojian.pervue.entity.User;
import com.zhaojian.pervue.entity.UserVo;
import com.zhaojian.pervue.mapper.UserMapper;
import com.zhaojian.pervue.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZJ
 * @since 2020-03-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public IPage<User> selectPageVo(Page<?> page, UserVo userVo) {
        return userMapper.selectPageVo(page,userVo);
    }
}
