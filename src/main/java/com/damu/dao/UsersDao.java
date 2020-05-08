package com.damu.dao;


import com.damu.entity.Users;
import com.damu.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;


import java.util.List;

/**
 * @author passionlife
 */
public class UsersDao {
    private SqlSession sqlsession;
    private List<Users> list;
    private Users user;


    private SqlSession getSqlsession(){
        sqlsession=SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        return sqlsession;
    }

    /**
     * 查询全部用户信息
     * @return
     */
    public List<Users> findUsers(){
       try {
           list = getSqlsession().selectList("findUsers");
       }catch(Exception e){
            e.printStackTrace();
        }finally {
            sqlsession.close();
        }
       return list;
    }

    /**
     * 根据id查找用户
     */

    public Users findUserById(Integer id){
        try {
          user= getSqlsession().selectOne("findUsers",new Users(id));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlsession.close();
        }
        return user;
    }

    /**
     * 增加用户
     * @param user
     * @return
     */
    public Users addUser(Users user){
        try {
            getSqlsession().insert("addUser", user);
            sqlsession.commit();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlsession.close();
        }
        return user;
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    public Users updateUser(Users user){
        try {
            getSqlsession().update("updateUser",user);
            sqlsession.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlsession.close();
        }
        return user;
    }

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    public boolean deleteUser(Integer id){
        try {
            if(getSqlsession().delete("deleteUser",id)>0){
                sqlsession.commit();
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlsession.close();
        }
        return false;
    }
}
