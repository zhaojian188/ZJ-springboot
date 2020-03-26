package com.zhaojian.pervue.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhaojian.pervue.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhaojian.pervue.entity.GoodsVo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ZJ
 * @since 2020-03-14
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    IPage<GoodsVo> selectPageVo(Page<?> page, GoodsVo goodsVo);
}
