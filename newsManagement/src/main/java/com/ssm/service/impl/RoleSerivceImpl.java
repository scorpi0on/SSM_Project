package com.ssm.service.impl;

import com.ssm.dao.RoleDao;
import com.ssm.po.Role;
import com.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleSerivceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findRoleList() {
        List<Role> roleList=roleDao.selectRoleList();
        return roleList;
    }
}
