package com.zhaojian.pervue.service.impl;

import com.zhaojian.pervue.entity.Nation;
import com.zhaojian.pervue.entity.NationVo;
import com.zhaojian.pervue.mapper.NationMapper;
import com.zhaojian.pervue.service.INationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 城市字典表 服务实现类
 * </p>
 *
 * @author ZJ
 * @since 2020-03-03
 */
@Service
public class NationServiceImpl extends ServiceImpl<NationMapper, Nation> implements INationService {

    @Resource
    private NationMapper nationMapper;

    @Override
    public List<NationVo> findAllCity() {
        return nationMapper.findAllCity();
    }
}
