package com.situ.web.servlet;

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
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("UserAll.service");
        String method = req.getParameter("method");

        if (method != null || method.equals("")) {
            method = "selectAll";
        }

        switch (method) {
            case "selectAll":
                selectAll(req, resp);
                break;
            case "addUser":
                addUser(req, resp);
                break;
            case "updateUser":
                updateUser(req, resp);
                break;
            case "deleteUser":
                deleteUser(req, resp);
                break;
        }
    }

    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("UserAll.deleteUser");
        String id = req.getParameter("id");
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
        }
        resp.sendRedirect(req.getContextPath() + "/user?method=selectAll");
    }

    private void updateUser(HttpServletRequest req, HttpServletResponse resp) {

    }

    public void getUserData(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("UserAll.getUserData");
        String id = req.getParameter("id");
        Connection connection = null;
    }

    private void addUser(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("UserAll.selectAll");
        Connection connection = null;
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
            }
            for (User user : list) {
                System.out.println(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement, resultSet);
        }
        req.setAttribute("list", list);
        req.getRequestDispatcher(req.getContextPath() + "/user/selectAll").forward(req, resp);
    }
}
