package com.zhaojian.pervue.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhaojian.pervue.entity.Role;
import com.zhaojian.pervue.entity.RoleVo;
import com.zhaojian.pervue.mapper.RoleMapper;
import com.zhaojian.pervue.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public IPage<RoleVo> selectPageVo(Page<?> page, RoleVo roleVo) {
        return roleMapper.selectPageVo(page,roleVo);
    }
}
