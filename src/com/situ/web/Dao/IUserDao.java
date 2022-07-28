package com.situ.web.Dao;

import com.situ.web.pojo.User;

import java.util.List;

public interface IUserDao {
     List<User> selectAllUser();
     void deleteUser(Integer id);
     void addUser(User user);
     User selectById(Integer id);
     void updateUser(User user);
}
