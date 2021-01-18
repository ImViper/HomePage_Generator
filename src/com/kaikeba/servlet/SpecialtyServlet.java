package com.kaikeba.servlet;

import com.kaikeba.bean.Result;
import com.kaikeba.bean.Specialty;
import com.kaikeba.service.DBService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/v1/specialty/insert")
public class SpecialtyServlet extends HttpServlet {
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
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Specialty specialty = new Specialty(userId,name,description);
        int row = DBService.insertSpecialty(specialty);
        Result result = null;
        if(row>0){
            result = new Result(0,"特长新增成功");
        }else{
            result = new Result(-1,"特长新增失败");
        }
        response.getWriter().append(result.toJSON());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
