package com.zhaojian.pervue.service.impl;

import com.zhaojian.pervue.entity.Employee;
import com.zhaojian.pervue.mapper.EmployeeMapper;
import com.zhaojian.pervue.service.IEmployeeService;
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
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
