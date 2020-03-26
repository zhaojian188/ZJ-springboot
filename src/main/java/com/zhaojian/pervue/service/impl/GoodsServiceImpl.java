package com.zhaojian.pervue.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhaojian.pervue.entity.Goods;
import com.zhaojian.pervue.entity.GoodsVo;
import com.zhaojian.pervue.mapper.GoodsMapper;
import com.zhaojian.pervue.service.IGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZJ
 * @since 2020-03-14
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public IPage<GoodsVo> selectPageVo(Page<?> page, GoodsVo goodsVo) {
        return goodsMapper.selectPageVo(page,goodsVo);
    }
}
