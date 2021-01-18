package com.kaikeba.db;

import com.kaikeba.bean.Edu;
import com.kaikeba.bean.Skill;
import com.kaikeba.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EduDaoImp implements BaseDao<Edu> {

    private static final String SQL_INSERT = "insert into kkb_edu(userid,start,end,school,study,description) values(?,?,?,?,?,?)";
    private static final String SQL_FIND_BY_USERID = "select * from kkb_edu where userid=? order by start";

    @Override
    public int insert(Edu edu){
        Connection conn = DBUtil.getConn();
        PreparedStatement state = null;
        ResultSet resultSte = null;
        try {
            state = conn.prepareStatement(SQL_INSERT);
            state.setInt(1,edu.getUserId());
            state.setString(2,edu.getStart());
            state.setString(3,edu.getEnd());
            state.setString(4,edu.getSchool());
            state.setString(5,edu.getStudy());
            state.setString(6,edu.getDescription());
            int row = state.executeUpdate();
            return row>0?row:-1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(conn,state,resultSte);
        }
        return -1;
    }

    @Override
    public Edu findByUserId(int userId){
        Connection conn = DBUtil.getConn();
        PreparedStatement state = null;
        ResultSet resultSte = null;
        Edu edu = null;
        try {
            state = conn.prepareStatement(SQL_FIND_BY_USERID);
            state.setInt(1,userId);
            resultSte = state.executeQuery();
            while(resultSte.next()){
                if(edu != null){
                    Edu temp = new Edu();
                    temp.setNext(edu);
                    edu = temp;
                }else{
                    edu = new Edu();
                }
                int id = resultSte.getInt("id");
                String start = resultSte.getString("start");
                String end = resultSte.getString("end");
                String school = resultSte.getString("school");
                String study = resultSte.getString("study");
                String description = resultSte.getString("description");
                edu.setId(id);
                edu.setStart(start);
                edu.setEnd(end);
                edu.setSchool(school);
                edu.setStudy(study);
                edu.setDescription(description);
                edu.setUserId(userId);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(conn,state,resultSte);
        }
        return edu;
    }
}
