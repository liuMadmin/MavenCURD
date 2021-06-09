package com.javacto.action.query;

import com.javacto.service.PhoneService;
import com.javacto.service.PhoneServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/queryPhone.do")
public class QueryPhoneAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String encoding = this.getServletContext().getInitParameter("encoding");
        req.setCharacterEncoding(encoding);
        resp.setContentType("text/html;charset="+encoding);

        PhoneService phoneService = new PhoneServiceImpl();
        List<Object> list = new ArrayList<Object>();

        list = phoneService.queryAll();
        req.setAttribute("Phones",list);
        req.getRequestDispatcher("/successPhone.jsp").forward(req,resp);
    }
}
