package com.damu.servlet;

import com.damu.dao.UsersDao;
import com.damu.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delUser.do")
public class UserDelSerclet extends HttpServlet {
    private UsersDao usersDao=new UsersDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取参数
        String id=req.getParameter("id");
        String type=req.getParameter("type");

        //2.进行删除或者锁定
        if("del".equals(type)){
             boolean flag=usersDao.deleteUser(Integer.valueOf(id));
             if(flag){
                 //跳转到首页
                 resp.sendRedirect("/index.do");
             }else {
                 System.out.println("删除失败...");
             }
        }else if("lock".equals(type)){
            Users user=new Users();

            user.setId(Integer.valueOf(id));
            user.setUserStatus(1);

            usersDao.updateUser(user);
            //跳转到首页
            resp.sendRedirect("/index.do");
        }else if("unlock".equals(type)){
            Users user=new Users();

            user.setId(Integer.valueOf(id));
            user.setUserStatus(0);

            usersDao.updateUser(user);
            //跳转到首页
            resp.sendRedirect("/index.do");
        }

    }
}
