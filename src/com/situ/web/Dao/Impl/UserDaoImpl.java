package com.situ.web.Dao.Impl;

import com.situ.web.Dao.IUserDao;
import com.situ.web.Util.JDBCUtil;
import com.situ.web.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements IUserDao {


    @Override
    public List<User> selectAllUser() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<User> list = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "SELECT * FROM user";
            statement = connection.prepareStatement(sql);
            System.out.println(statement);
            resultSet = statement.executeQuery();
//            System.out.println(resultSet);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String tel = resultSet.getString("tel");
                User user = new User(id, username, password, email, tel);
                list.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public void deleteUser(Integer id) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "DELETE FROM user where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            System.out.println(statement);
            int count = statement.executeUpdate();
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement, null);
        }
    }

    @Override
    public void addUser(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql ="insert into user (name, password, email, tel) value(?, ?, ?, ?)";
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getTel());
            int count = statement.executeUpdate();
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement, null);
        }
    }

    @Override
    public User selectById(Integer id) {
        User user = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select username, password, email, tel from user where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);//这是关键地方记住这里
            System.out.println(statement);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String userName = resultSet.getString("userName");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String tel = resultSet.getString("tel");
                user = new User(userName, password, email, tel);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement, resultSet);
        }
        return user;
    }

    @Override
    public void updateUser(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql ="update user set username = ?, password = ?, email = ?, tel = ? where id = ?";

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getTel());
            statement.setInt(5, user.getId());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement, null);
        }
    }
}
