package com.kaikeba.servlet;

import com.kaikeba.bean.Result;
import com.kaikeba.bean.Skill;
import com.kaikeba.service.DBService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/v1/skill/insert")
public class SkillServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=utf-8");

        int userId = 0;
        String userIdText = request.getParameter("userid");
        if(userIdText != null){
            try {
                userId = Integer.parseInt(userIdText);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        String keywords = request.getParameter("keywords");
        Skill skill = new Skill(userId,keywords);
        int row = DBService.insertSkill(skill);
        Result result = null;
        if(row>0){
            result = new Result(0,"技能列表新增成功");
        }else{
            result = new Result(-1,"技能列表新增失败");
        }
        response.getWriter().append(result.toJSON());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
