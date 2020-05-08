package com.damu.servlet;

import com.damu.dao.UsersDao;
import com.damu.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/index.do")
public class UsersFindServlet extends HttpServlet {

    private UsersDao usersDao=new UsersDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Users> list=usersDao.findUsers();
        req.setAttribute("userList",list);
        req.getRequestDispatcher("index.jsp").forward(req,resp);

    }
}
