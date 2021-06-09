package com.javacto.action.add;

import com.javacto.po.Computer;
import com.javacto.service.ComputerService;
import com.javacto.service.ComputerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addComputer.do")
public class AddComputerAction extends HttpServlet {
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
        String color = req.getParameter("color");
        String strMoney = req.getParameter("money");
        double money = Double.parseDouble(strMoney);

        Computer computer = new Computer();
        computer.setcName(cName);
        computer.setColor(color);
        computer.setMoney(money);

        ComputerService computerService = new ComputerServiceImpl();
        computerService.addComputer(computer);

        req.getRequestDispatcher("/pageQueryComputer.do").forward(req,resp);
    }
}
