package com.javacto.action.login;

import com.javacto.service.DogService;
import com.javacto.service.DogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/loginDog.do")
public class LoginDogAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String encoding = this.getServletContext().getInitParameter("encoding");
        req.setCharacterEncoding(encoding);
        resp.setContentType("text/html;charset="+encoding);

        String dogName = req.getParameter("dogName");

        DogService dogService = new DogServiceImpl();
        List<Object> list = new ArrayList<Object>();

        list = dogService.queryDogByName(dogName);
        if (list.size()==0){
            req.getRequestDispatcher("/fail.jsp").forward(req,resp);  //请求转发不能加路径,重定向必须要带工程名
        }else {
            req.getRequestDispatcher("/pageQueryDog.do").forward(req,resp);
        }
    }
}
