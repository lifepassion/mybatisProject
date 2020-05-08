package com.damu.servlet;

import com.damu.dao.UsersDao;
import com.damu.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author passionlife
 */
@WebServlet("/addUser.do")
public class UserAddServlet extends HttpServlet {

    UsersDao usersDao=new UsersDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户输入值
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String nickname=req.getParameter("nickname");
        String age=req.getParameter("age");
        String gender=req.getParameter("gender");
        String phone=req.getParameter("phone");
        String email=req.getParameter("email");
        String remark=req.getParameter("remark");

        //构建User对象
        Users user=new Users(username,password,nickname, Integer.parseInt(age)
                ,gender,phone,email,new Date(),new Date(),new Date(),
                0,remark);

        //调用usersDao执行
        user= usersDao.addUser(user);

        //跳转到显示页面
        resp.sendRedirect("/detail.do?id="+user.getId());
    }
}
