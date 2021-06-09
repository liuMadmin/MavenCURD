package com.javacto.action.query;

import com.javacto.po.Computer;
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

@WebServlet("/queryComputerById.do")
public class QueryComputerByIdAction extends HttpServlet {
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
        Integer cpId = Integer.parseInt(strId);

        List<Object> list = new ArrayList<Object>();
        ComputerService computerService = new ComputerServiceImpl();
        list = computerService.queryComputerById(cpId);
        Computer computer = (Computer) list.get(0);
        req.setAttribute("computer",computer);

        req.getRequestDispatcher("/updateComputer.jsp").forward(req,resp);

    }
}
