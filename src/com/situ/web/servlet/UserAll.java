package com.situ.web.servlet;

import com.situ.web.Dao.Impl.UserDaoImpl;
import com.situ.web.Service.ServiceImpl.UserServiceImpl;
import com.situ.web.Service.UserService;
import com.situ.web.Util.JDBCUtil;
import com.situ.web.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/user")
public class UserAll extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");

        if (method != null || method.equals("")) {
            method = "selectAllUser";
        }
        switch (method) {
            case "selectAllUser":
                selectAllUser(req, resp);
                break;
            case "addUser":
                addUser(req, resp);
                break;
            case "updateUser":
                updateUser(req, resp);
                break;
            case "selectById":
                selectById(req, resp);
                break;
            case "deleteUser":
                deleteUser(req, resp);
                break;
        }
    }

    private void selectById(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        /*String id = req.getParameter("id");
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "DELETE FROM user WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(id));
            System.out.println(statement);
            int count = statement.executeUpdate();
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/
        String id = req.getParameter("id");
        userService.deleteUser(Integer.parseInt(id));//只需要将网页的数据封装起来传递到service。
        resp.sendRedirect(req.getContextPath() + "/user?method=selectAllUser");
    }

    private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        User user = userService.selectById(Integer.parseInt(id));
        userService.updateUser(user);
        resp.sendRedirect(req.getContextPath() + "/user?method=selectAllUser");
    }

    private void addUser(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String tel = req.getParameter("tel");
        User user = new User(name, password, email, tel);
        userService.addUser(user);
        /*Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql ="insert into user (name, password, email, tel) value(?, ?, ?, ?)";
            statement.setString(1, "name");
            statement.setString(2, "password");
            statement.setString(3, "email");
            statement.setString(4, "tel");
            int count = statement.executeUpdate();
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement, null);
        }*/
    }

    private void selectAllUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<User> list = new ArrayList<User>();
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select * from user";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String tel = resultSet.getString("tel");
                User user = new User(id, username, password, email, tel);
                list.add(user);
            }*/
/*            for (User user : list) {
                System.out.println(user);
            }*/
        /*} catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement, resultSet);
        }*/
        List<User> list = userService.selectAllUser();
        req.setAttribute("list", list);
        req.getRequestDispatcher("user_list.jsp").forward(req, resp);
    }
}
