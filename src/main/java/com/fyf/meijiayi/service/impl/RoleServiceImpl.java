package com.fyf.meijiayi.service.impl;

import com.fyf.meijiayi.mapper.RoleMapper;
import com.fyf.meijiayi.pojo.Role;
import com.fyf.meijiayi.pojo.RoleExample;
import com.fyf.meijiayi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {



    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> selectAll() {
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andIdIsNotNull();
        List<Role> roles = roleMapper.selectByExample(roleExample);
        return roles;
    }

    @Override
    public Role selectById(int id) {
        Role role = roleMapper.selectByPrimaryKey(id);
        return role;
    }

    @Override
    public  List<Role> selectByName(String name) {
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andRolenameEqualTo(name);
        List<Role> roles = roleMapper.selectByExample(roleExample);
        return roles;
    }

}
