package com.warren.dao;

import com.warren.pojo.User;
import com.warren.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {

    @Test
    public void test(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void getUserById(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //获取getMapper
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.getUserById(1);

        System.out.println(user);

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserLike("李");
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void addUser(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //获取getMapper
        UserDao userDao = sqlSession.getMapper(UserDao.class);
//        int number = userDao.addUser(new User(4, "warren", "666666"));
        int number = userDao.addUser(new User(5, "李五", "555555"));
        if (number > 0){
            System.out.println(number + "列插入成功！");
        }
        //提交事务
        sqlSession.commit();
        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        int number = mapper.updateUser(new User(4, "warren2", "123123"));
        if (number > 0){
            System.out.println(number + "列修改成功！");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser2(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //获取getMapper
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        //利用map就不用传递整个对象了
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("userid",4);
        map.put("password","hashMap6");

        int number = userDao.updateUser2(map);
        if (number > 0){
            System.out.println(number + "列修改成功！");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        int number = mapper.deleteUser(4);
        if (number > 0){
            System.out.println(number + "列删除成功！");
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
