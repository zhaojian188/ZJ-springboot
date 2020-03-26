package com.zhaojian.pervue.service.impl;

import com.zhaojian.pervue.entity.Test;
import com.zhaojian.pervue.mapper.TestMapper;
import com.zhaojian.pervue.service.ITestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {

}
