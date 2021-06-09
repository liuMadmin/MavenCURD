package com.javacto.action.login;

import com.javacto.service.ComputerService;
import com.javacto.service.ComputerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/loginComputer.do")
public class LoginComputerAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String encoding = this.getServletContext().getInitParameter("encoding");
        req.setCharacterEncoding(encoding);
        resp.setContentType("text/html;charset="+encoding);

        String cName = req.getParameter("cName");

        ComputerService computerService = new ComputerServiceImpl();
        List<Object> list = new ArrayList<Object>();

        list = computerService.queryComputerByName(cName);
        if (list.size()==0){
            req.getRequestDispatcher("/fail.jsp").forward(req,resp);
        }else {
            req.getRequestDispatcher("/pageQueryComputer.do").forward(req,resp);
        }
    }
}
