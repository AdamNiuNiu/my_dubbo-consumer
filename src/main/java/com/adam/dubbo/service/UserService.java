package com.adam.dubbo.service;



import com.adam.dubbo.pojo.User;

import java.util.List;

public interface UserService {

    /**
     * 查询所有的用户数据
     * @return
     */
    List<User> queryAll();
}
