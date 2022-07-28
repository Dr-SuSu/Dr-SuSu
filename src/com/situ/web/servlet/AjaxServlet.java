package com.situ.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ajax")
public class AjaxServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AjaxServlet.doGet");
        // {'name': 'zhangsan'}
        String name = req.getParameter("name");
        System.out.println(name);
        // {"name": "李四","age":23}
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("{\"name\": \"李四\",\"age\":23}");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AjaxServlet.doPost");
        // req.setCharacterEncoding("UTF-8");

        try {
            Thread.sleep(3000);/*等待时间3000ms=3秒*/
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // {'name': 'zhangsan'}
        String name = req.getParameter("name");
        System.out.println(name);
        // {"name": "李四","age":23}
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("{\"name\": \"李四11\",\"age\":24}");

        // doGet(req, resp);
    }
}
