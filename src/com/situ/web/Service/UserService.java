package com.situ.web.Service;

import com.situ.web.pojo.User;

import java.util.List;

public interface UserService {

    List<User> selectAllUser();
    void deleteUser(Integer id);
    void addUser(User user);
    User selectById(Integer id);
    void updateUser(User user);
}
