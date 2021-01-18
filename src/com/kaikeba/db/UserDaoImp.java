package com.kaikeba.db;

import com.kaikeba.bean.User;
import com.kaikeba.util.DBUtil;
import com.kaikeba.util.DBUtil;
import java.sql.*;

public class UserDaoImp implements BaseDao<User>{
    private static final String SQL_INSERT = "insert into kkb_user(name,age,city,address,email,phone,weixin,qq,weibo,sex,description) values(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_FIND_BY_USERID = "select * from kkb_user where id=?";

    @Override
    public int insert(User o) {
        //1.    得到链接
        Connection conn = DBUtil.getConn();
        PreparedStatement state = null;
        try {

            //2.    得到执行环境
            state = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            //3.    向执行环境中，填充参数、
            state.setString(1,o.getName());
            state.setInt(2,o.getAge());
            state.setString(3,o.getCity());
            state.setString(4,o.getAddress());
            state.setString(5,o.getEmail());
            state.setString(6,o.getPhone());
            state.setString(7,o.getWeixin());
            state.setString(8,o.getQq());
            state.setString(9,o.getWeibo());
            state.setString(10,o.getSex());
            state.setString(11,o.getDescription());
            //4.    执行
            state.executeUpdate();
            ResultSet rs = state.getGeneratedKeys();
            if(rs.next()){
                //5.    将数据的插入结果返回
                return rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //释放数据库资源
            DBUtil.close(conn,state,null);
        }
        return -1;
    }

    @Override
    public User findByUserId(int userId) {
        try {
            //1.    链接数据库
            Connection conn = DBUtil.getConn();
            //2。    获取执行环境
            PreparedStatement state = conn.prepareStatement(SQL_FIND_BY_USERID);
            //3。    填充执行参数
            state.setInt(1,userId);
            //4。    执行并获取结果
            ResultSet resultSet = state.executeQuery();
            while(resultSet.next()){
                int age = resultSet.getInt("age");
                String name = resultSet.getString("name");
                String city = resultSet.getString("city");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String weixin = resultSet.getString("weixin");
                String qq = resultSet.getString("qq");
                String weibo = resultSet.getString("weibo");
                String sex = resultSet.getString("sex");
                String description = resultSet.getString("description");
                User user = new User(name,age,city,address,email,phone,weixin,qq,weibo,sex,description);
                //5。    将结果返回
                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
}
