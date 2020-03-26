package com.zhaojian.pervue.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhaojian.pervue.entity.Menu_role;
import com.zhaojian.pervue.mapper.Menu_roleMapper;
import com.zhaojian.pervue.service.IMenu_roleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZJ
 * @since 2020-03-03
 */
@Service
public class Menu_roleServiceImpl extends ServiceImpl<Menu_roleMapper, Menu_role> implements IMenu_roleService {
    @Autowired
    private Menu_roleMapper menu_roleMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)   //执行事务回滚
    public void insertBatch(Integer rid, Integer[] mids) throws Exception {
        //先删除角色对应的资源这张中间表对应的数据menu_role
        QueryWrapper wrapper = new QueryWrapper();
        //指定对应的列和属性
        wrapper.eq("rid",rid);
        //删除rid对应的值
        menu_roleMapper.delete(wrapper);

        //int i=1/0;
        //判断操作，如果菜单不是空，执行添加操作
        if(mids!=null && mids.length>0){
            for (Integer mid : mids) {
                Menu_role menu_role = new Menu_role();
                //资源id
                menu_role.setMid(mid);
                //用户角色id
                menu_role.setRid(rid);
                //调用框架写好的insert方法添加到数据库中
                menu_roleMapper.insert(menu_role);
            }
        }
    }
}
