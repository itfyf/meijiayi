package com.fyf.meijiayi.service;

import com.fyf.meijiayi.pojo.Role;

import java.util.List;

public interface RoleService {

    List<Role> selectAll();

    Role selectById(int id);

    List<Role> selectByName(String name);
}
