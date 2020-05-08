package com.damu.servlet;

import com.damu.dao.UsersDao;
import com.damu.entity.Users;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author passionlife
 */
@WebServlet("/detail.do")
public class UserDetailServlet extends HttpServlet {

    private Logger log=Logger.getLogger(UserDetailServlet.class);

    private UsersDao usersDao = new UsersDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        log.info("获取到查询的id"+id);

        Users user = usersDao.findUserById(Integer.parseInt(id));
        log.info("获取到查询的user"+user);

        req.setAttribute("user", user);
        req.getRequestDispatcher("detail.jsp").forward(req, resp);
    }
}
