package com.ssm.jdbc;

import java.util.List;

public interface UserDao {
    public int addUser(User user);

    public int updateUser(User user);

    public int deletUser(int id);

    public User findUserById(int id);

    public List<User> findAllUser();

    public void transfer(String outUser, String inUser, Integer jf);

}

