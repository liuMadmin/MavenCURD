package com.javacto.action.update;

import com.javacto.po.Phone;
import com.javacto.service.PhoneService;
import com.javacto.service.PhoneServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatePhone.do")
public class updatePhoneAction extends HttpServlet {
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
        int pId = Integer.parseInt(strId);
        String pName = req.getParameter("pName");
        String color = req.getParameter("color");
        String strMoney = req.getParameter("money");
        double money = Double.parseDouble(strMoney);

        Phone phone = new Phone();
        phone.setId(pId);
        phone.setpName(pName);
        phone.setColor(color);
        phone.setMoney(money);

        PhoneService phoneService = new PhoneServiceImpl();
        phoneService.updatephone(phone);

        req.getRequestDispatcher("/pageQueryPhone.do").forward(req,resp);

    }
}
