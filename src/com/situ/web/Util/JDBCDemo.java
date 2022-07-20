package com.situ.web.Util;

import com.situ.web.pojo.Student;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo {

    @Test
    public void test1() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //1、加载驱动Class.forName("");
            Class.forName("com.mysql.jdbc.Driver");
            //2、获得连接对象Connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java2207", "root", "5130550");
            //3、写sql语句
            String sql = "select id,name,age,gender from student";
            //4、创建Statement(一艘船)
            statement = connection.createStatement();
            //5、执行sql语句
            //        (1) 更新类（更改了表里面数据）：delete/update/insert     executeUpdate()
            //返回值：int，表示你影响的行数
            //        (2)查询（没有改变表里面数据）:  select                  executeQuery()
            //返回值：结果集ResultSet
            resultSet = statement.executeQuery(sql);
            List<Student> list = new ArrayList<>();
            while (resultSet.next()) {// 如果有下一个返回true，而且指向下一个
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                Student student = new Student(id, name, age, gender);
                list.add(student);
            }

            for (Student student : list) {
                System.out.println(student);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //6、关闭连接 先打开的后关闭
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }
    }

    @Test
    public void test2() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select id,name,age,gender from student";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            List<Student> list = new ArrayList<>();
            while (resultSet.next()) {// 如果有下一个返回true，而且指向下一个
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                Student student = new Student(id, name, age, gender);
                list.add(student);
            }
            for (Student student : list) {
                System.out.println(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement, resultSet);
        }
    }

    @Test
    public void testPreparedStatement() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select id,name,age,gender from student";
            statement = connection.prepareStatement(sql);
            System.out.println(statement);
            resultSet = statement.executeQuery();
            List<Student> list = new ArrayList<>();
            while (resultSet.next()) {// 如果有下一个返回true，而且指向下一个
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                Student student = new Student(id, name, age, gender);
                list.add(student);
            }
            for (Student student : list) {
                System.out.println(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement, resultSet);
        }
    }

    @Test
    public void testInsert() {
        String name = "zhansgan";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "insert into student(name,age,gender) values(?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "张三111");
            statement.setInt(2, 23);
            statement.setString(3, "男");
            System.out.println(statement);
            int count = statement.executeUpdate();
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement, null);
        }
    }

    @Test
    public void testDelete() {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "delete from student where id=?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 9);
            System.out.println(statement);
            int count = statement.executeUpdate();
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement, null);
        }
    }

    @Test
    public void testUpdate() {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "update student set name=?,age=?,gender=? where id=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "李四");
            statement.setInt(2, 24);
            statement.setString(3, "女");
            statement.setInt(4, 7);
            System.out.println(statement);
            int count = statement.executeUpdate();
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement, null);
        }
    }

}
