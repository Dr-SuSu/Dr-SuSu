package com.situ.web.Service.ServiceImpl;

import com.situ.web.Service.UserService;
import com.situ.web.pojo.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserService userService = new UserServiceImpl();
    @Override
    public List<User> selectAllUser() {
        return userService.selectAllUser();
    }

    @Override
    public void deleteUser(Integer id) {
        userService.deleteUser(id);
    }

    @Override
    public void addUser(User user) {
        userService.addUser(user);
    }

    @Override
    public User selectById(Integer id) {
        return userService.selectById(id);
    }

    @Override
    public void updateUser(User user) {
        userService.updateUser(user);
    }
}
