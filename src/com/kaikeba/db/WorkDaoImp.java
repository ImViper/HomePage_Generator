package com.kaikeba.db;

import com.kaikeba.bean.Edu;
import com.kaikeba.bean.User;
import com.kaikeba.bean.Work;
import com.kaikeba.util.DBUtil;
import java.sql.*;

public class WorkDaoImp implements BaseDao<Work> {

    private static final String SQL_INSERT = "insert into kkb_work(userid,start,end,company,job,description) values(?,?,?,?,?,?)";
    private static final String SQL_FIND_BY_USERID = "select * from kkb_work where userid=? order by start";

    @Override
    public int insert(Work work){
        Connection conn = DBUtil.getConn();
        PreparedStatement state = null;
        ResultSet resultSte = null;
        try {
            state = conn.prepareStatement(SQL_INSERT);
            state.setInt(1,work.getUserId());
            state.setString(2,work.getStart());
            state.setString(3,work.getEnd());
            state.setString(4,work.getCompany());
            state.setString(5,work.getJob());
            state.setString(6,work.getDescription());
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
    public Work findByUserId(int userId){
        Connection conn = DBUtil.getConn();
        PreparedStatement state = null;
        ResultSet resultSte = null;
        Work work = null;
        try {
            state = conn.prepareStatement(SQL_FIND_BY_USERID);
            state.setInt(1,userId);
            resultSte = state.executeQuery();
            while(resultSte.next()){
                if(work != null){
                    Work temp = new Work();
                    temp.setNext(work);
                    work = temp;
                }else{
                    work = new Work();
                }
                int id = resultSte.getInt("id");
                String start = resultSte.getString("start");
                String  end = resultSte.getString("end");
                String company = resultSte.getString("company");
                String job = resultSte.getString("job");
                String description = resultSte.getString("description");
                work.setId(id);
                work.setStart(start);
                work.setEnd(end);
                work.setCompany(company);
                work.setJob(job);
                work.setDescription(description);
                work.setUserId(userId);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close(conn,state,resultSte);
        }
        return work;
    }
}
