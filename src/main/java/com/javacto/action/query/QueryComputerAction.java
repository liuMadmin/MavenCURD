package com.javacto.action.query;

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

@WebServlet("/queryComputer.do")
public class QueryComputerAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String encoding = this.getServletContext().getInitParameter("encoding");
        req.setCharacterEncoding(encoding);
        resp.setContentType("text/html;charset="+encoding);

        ComputerService computerService = new ComputerServiceImpl();
        List<Object> list = new ArrayList<Object>();

        list = computerService.queryAll();
        req.setAttribute("Computers",list);
        req.getRequestDispatcher("/successComputer.jsp").forward(req,resp);
    }
}
