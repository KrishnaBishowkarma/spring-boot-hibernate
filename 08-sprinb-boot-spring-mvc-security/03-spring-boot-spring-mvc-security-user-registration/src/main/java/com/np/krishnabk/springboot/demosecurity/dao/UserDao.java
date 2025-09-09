package com.np.krishnabk.springboot.demosecurity.dao;

import com.np.krishnabk.springboot.demosecurity.entity.User;

public interface UserDao {

    User findByUserName(String userName);

    void save(User theUser);
}
