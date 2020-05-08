package com.damu.utils;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author passionlife
 */

public class SqlSessionFactoryUtils {
    private static String resource = "myBatis.xml";
    private static SqlSessionFactory sqlSessionFactory;
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();

    /**
     * 创建一个初始化SqlSessionFactory方法
     */

    public static void initSqlSessionFactory() {

        try {
            //1.获取配置文件输入流
            InputStream is = Resources.getResourceAsStream(resource);
            //2.初始化SqlSessionFactory对象
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取工厂对象的方法
     */

    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }


    /**
     * 关闭SqlSessionFactory的方法
     */
    public static void close(){
        SqlSession session = threadLocal.get();
        if(session!=null){
            session.close();
            threadLocal.set(null);
        }
    }


}
