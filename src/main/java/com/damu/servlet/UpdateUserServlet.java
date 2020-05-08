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
@WebServlet("/updateUser.do")
public class UpdateUserServlet extends HttpServlet {
    private UsersDao usersDao=new UsersDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取数据
        String id=req.getParameter("id");
        String nickname=req.getParameter("nickname");
        String age=req.getParameter("age");
        String gender=req.getParameter("gender");
        String phone=req.getParameter("phone");
        String email=req.getParameter("email");
        String remark=req.getParameter("remark");
        //2.构建user对象
        Users user=new Users(Integer.parseInt(id),nickname,Integer.parseInt(age),gender,phone,email,new Date(),remark);
        //3.调用UsersDao处理
        usersDao.updateUser(user);
        //4.跳转到详情页面
        resp.sendRedirect("/detail.do?id="+user.getId());
    }
}
