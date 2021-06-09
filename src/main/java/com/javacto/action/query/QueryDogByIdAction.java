package com.javacto.action.query;

import com.javacto.po.Dog;
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

@WebServlet("/queryDogById.do")
public class QueryDogByIdAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String encoding = this.getServletContext().getInitParameter("encoding");
        req.setCharacterEncoding(encoding);
        resp.setContentType("text/html;charset="+encoding);

        String strId = req.getParameter("id");
        Integer dogId = Integer.parseInt(strId);

        List<Object> list = new ArrayList<Object>();
        DogService dogService = new DogServiceImpl();
        list = dogService.queryDogById(dogId);
        Dog dog = (Dog) list.get(0);
        req.setAttribute("dog",dog);

        req.getRequestDispatcher("/updateDog.jsp").forward(req,resp);

    }
}
