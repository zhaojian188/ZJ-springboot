package com.zhaojian.pervue.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhaojian.pervue.entity.User;
import com.zhaojian.pervue.entity.UserVo;
import com.zhaojian.pervue.service.IUserService;
import com.zhaojian.pervue.vo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ZJ
 * @since 2020-03-03
 */
//一定要记住注解写RestController，因为他返回的是json串
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    /**
     * 添加列表
     * @param current
     * @param size
     * @return
     */
    @RequestMapping("/list")
    public ResultEntity list(@RequestParam(defaultValue = "1") long current,
                             @RequestParam(defaultValue = "3") long size, UserVo userVo){
        Page<User> page = new Page<>(current,size);
        QueryWrapper queryWrapper =new QueryWrapper();
        //自定义查询分页实现
        IPage<User> pageInfo = iUserService.selectPageVo(page, userVo);
//      Page pageInfo = iUserService.page(page, queryWrapper);
        return ResultEntity.ok(pageInfo);
    }

    /**
     * 删除列表
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public ResultEntity delete(Integer ids[]){
        boolean flag = iUserService.removeByIds(Arrays.asList(ids));
        return ResultEntity.ok(flag);
    }

    /**
     * 用户添加的方法
     * @param entity
     * @return
     */
    @RequestMapping("/insert")
    public ResultEntity insert(@RequestBody User entity) {
        boolean flag = iUserService.save(entity);
        return ResultEntity.ok(flag);
    }

    /**
     * 用户编辑的方法
     * @param entity
     * @return
     */
    @RequestMapping("/update")
    public ResultEntity update(@RequestBody User entity) {
        boolean flag = iUserService.updateById(entity);
        return ResultEntity.ok(flag);
    }

    /**
     * 登录系统
     * @param request
     * @param user
     * @return
     */
    @RequestMapping("/login")
    public ResultEntity login(HttpServletRequest request,@RequestBody User user) {
        //获取session对象
        HttpSession session = request.getSession();
        //输出session的id
        System.out.println(session.getId()+"@@@@@@@@@@@@@@");
        //定义查询条件
        QueryWrapper wrapper = new QueryWrapper();
        //username名称唯一
        wrapper.eq("username",user.getUsername());
        //获取实体对象
        User entity = iUserService.getOne(wrapper);
        //判断结果
        if(entity!=null){
            //判断密码是否正确
            if(entity.getPassword().equals(user.getPassword())){
                //存储会话
                session.setAttribute("user",entity);
                //返回结果
                return ResultEntity.ok(entity);
            }
        }
        return ResultEntity.error(5001,"用户名或密码错误");
    }

    /**
     * 注销登录
     * @param request
     * @return
     */
    @RequestMapping("/loginOut")
    public ResultEntity loginOut(HttpServletRequest request){
        //获取session对象
        HttpSession session = request.getSession();
        //输出session的id
        System.err.println(session.getId()+"===========");
        //清空当前session
        session.removeAttribute("user");
        return ResultEntity.ok(true);
    }


    /*get请求方式，会暴露属性名
    @RequestMapping("/login")
    public ResultEntity login(HttpServletRequest request,String username,String password) {
        //获取session对象
        HttpSession session = request.getSession();
        //输出session的id
        System.out.println(session.getId()+"@@@@@@@@@@@@@@");
        //定义查询条件
        QueryWrapper wrapper = new QueryWrapper();
        //username名称唯一
        wrapper.eq("username",username);
        //获取实体对象
        User entity = iUserService.getOne(wrapper);
        //判断结果
        if(entity!=null){
            //判断密码是否正确
            if(entity.getPassword().equals(password)){
                //存储会话
                session.setAttribute("user",entity);
                //返回结果
                return ResultEntity.ok(entity);
            }
        }
        return ResultEntity.error(5001,"用户名或密码错误");
    }*/
}

