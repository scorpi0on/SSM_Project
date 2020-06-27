package com.ssm.annotation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService{
    //属性注入
    @Resource(name="userDao")
    private UserDao userDao;

    @Override
    public void save() {
        this.userDao.save();
        System.out.println("执行userService.save()");
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
