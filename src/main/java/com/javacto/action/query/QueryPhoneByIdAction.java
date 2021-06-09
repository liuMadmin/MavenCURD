package com.javacto.action.query;

import com.javacto.po.Phone;
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

@WebServlet("/queryPhoneById.do")
public class QueryPhoneByIdAction extends HttpServlet {
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
        Integer pId = Integer.parseInt(strId);

        List<Object> list = new ArrayList<Object>();
        PhoneService phoneService = new PhoneServiceImpl();
        list = phoneService.queryPhoneById(pId);
        Phone phone = (Phone) list.get(0);
        req.setAttribute("phone",phone);

        req.getRequestDispatcher("/updatePhone.jsp").forward(req,resp);

    }
}
