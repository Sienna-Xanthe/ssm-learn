package com.itheima.mapper;

import com.itheima.domain.Users;

import java.util.List;

public interface UserMapper {

    public List<Users> findAll();

    public List<Users> findUserAndRoleAll();
}
