package com.zhaojian.pervue.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhaojian.pervue.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhaojian.pervue.entity.GoodsVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ZJ
 * @since 2020-03-14
 */
public interface IGoodsService extends IService<Goods> {

    IPage<GoodsVo> selectPageVo(Page<?> page, GoodsVo goodsVo);
}
