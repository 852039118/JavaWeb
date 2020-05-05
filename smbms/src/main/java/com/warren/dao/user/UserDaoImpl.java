package com.warren.dao.user;

import com.mysql.cj.util.StringUtils;
import com.warren.dao.BaseDao;
import com.warren.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    public User getLoginUser(Connection connection, String userCode,String userPassword) throws SQLException {

        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;

        if(connection != null){
            String sql = "select * from smbms_user where userCode=? and userPassword =? ";
            Object[] params = {userCode,userPassword};

            rs = BaseDao.excute(connection,pstm,rs,sql,params);
            if (rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setGender(rs.getInt("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setUserRole(rs.getInt("userRole"));
                user.setCreatedBy(rs.getInt("createdBy"));
                user.setCreationDate(rs.getTimestamp("creationDate"));
                user.setModifyBy(rs.getInt("modifyBy"));
                user.setModifyDate(rs.getTimestamp("modifyDate"));
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return user;
    }

    //修改当前用户密码 : 根据ID
    public int updatePwd(Connection connection, int id, String pwd) throws SQLException {
        PreparedStatement pstm = null;
        int excute = 0;
        if (connection != null){
            String sql = "update smbms_user set userPassword = ? where id = ?";
            Object[] params = {pwd,id};
            excute = BaseDao.excute(connection, pstm, sql, params);
        }
        return excute;
    }
    //根据用户名或者角色查询用户总数
    public int getUserCount(Connection connection, String userName, int userRole) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int count = 0;

        if (connection != null){
            StringBuffer sql = new StringBuffer();
            sql.append("select count(1) count from smbms_user u ,smbms_role r where u.userRole = r.id");
            ArrayList<Object> list = new ArrayList<Object>();   //存放我们的参数

            if (!StringUtils.isNullOrEmpty(userName)){
                sql.append(" and u.userName like ? ");
                list.add("%" + userName + "%");
            }
            if (userRole > 0){
                sql.append(" and u.userRole = ? ");
                list.add(userRole);
            }
            System.out.println("UserDaoImpl -> getUserCount : " + sql);
            Object[] params = list.toArray();   //怎么把list转为数组

            rs = BaseDao.excute(connection, pstm, rs, sql.toString(), params);

            if (rs.next()){
                count = rs.getInt("count");
            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return count;
    }

    public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<User> userList = new ArrayList<User>();
        if(connection != null){
            StringBuffer sql = new StringBuffer();
            sql.append("select u.*,r.roleName as userRoleName from smbms_user u,smbms_role r where u.userRole = r.id");
            List<Object> list = new ArrayList<Object>();
            if(!StringUtils.isNullOrEmpty(userName)){
                sql.append(" and u.userName like ?");
                list.add("%"+userName+"%");
            }
            if(userRole > 0){
                sql.append(" and u.userRole = ?");
                list.add(userRole);
            }
            sql.append(" order by creationDate DESC limit ?,?");
            currentPageNo = (currentPageNo-1)*pageSize;
            list.add(currentPageNo);
            list.add(pageSize);

            Object[] params = list.toArray();
            System.out.println("sql ----> " + sql.toString());
            rs = BaseDao.excute(connection, pstm, rs, sql.toString(), params);
            while(rs.next()){
                User _user = new User();
                _user.setId(rs.getInt("id"));
                _user.setUserCode(rs.getString("userCode"));
                _user.setUserName(rs.getString("userName"));
                _user.setGender(rs.getInt("gender"));
                _user.setBirthday(rs.getDate("birthday"));
                _user.setPhone(rs.getString("phone"));
                _user.setUserRole(rs.getInt("userRole"));
                _user.setUserRoleName(rs.getString("userRoleName"));
                userList.add(_user);
            }
            BaseDao.closeResource(null, pstm, rs);
        }
        return userList;
    }

}
