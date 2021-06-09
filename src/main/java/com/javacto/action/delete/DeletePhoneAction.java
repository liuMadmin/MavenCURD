package com.javacto.action.delete;

import com.javacto.service.PhoneService;
import com.javacto.service.PhoneServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deletePhone")
public class DeletePhoneAction extends HttpServlet {
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
        Integer id = Integer.parseInt(strId);

        PhoneService phoneService = new PhoneServiceImpl();

        int num = phoneService.deletePhone(id);

        req.getRequestDispatcher("/pageQueryPhone.do").forward(req,resp);
    }
}
