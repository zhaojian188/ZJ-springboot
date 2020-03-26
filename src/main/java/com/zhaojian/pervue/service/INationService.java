package com.zhaojian.pervue.service;

import com.zhaojian.pervue.entity.Nation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhaojian.pervue.entity.NationVo;

import java.util.List;

/**
 * <p>
 * 城市字典表 服务类
 * </p>
 *
 * @author ZJ
 * @since 2020-03-03
 */
public interface INationService extends IService<Nation> {
    /**
     * 查询所有城市的数据
     * @return
     */
    List<NationVo> findAllCity();
}
