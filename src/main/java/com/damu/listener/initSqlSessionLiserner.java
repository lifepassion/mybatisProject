package com.damu.listener;

import com.damu.utils.SqlSessionFactoryUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author passionlife
 */

@WebListener
public class initSqlSessionLiserner implements ServletContextListener {


    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //初始化SqlSessionFactory对象
        System.out.println("容器加载中");
        SqlSessionFactoryUtils.initSqlSessionFactory();
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //关闭SqlSessionFactory对象
        System.out.println("容器销毁中");
        SqlSessionFactoryUtils.close();
    }
}
