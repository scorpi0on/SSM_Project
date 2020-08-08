package com.ssm.dao;
import com.ssm.po.User;
/*
 * User接口文件
 */
public interface UserDao {
    /*
     * 根据id查询用户信息
     */
    public User findUserById(Integer id);
}