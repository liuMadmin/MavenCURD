package com.javacto.action.login;

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

@WebServlet("/loginPhone.do")
public class LoginPhoneAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String encoding = this.getServletContext().getInitParameter("encoding");
        req.setCharacterEncoding(encoding);
        resp.setContentType("text/html;charset="+encoding);

        String phoneName = req.getParameter("phoneName");

        PhoneService phoneService = new PhoneServiceImpl();
        List<Object> list = new ArrayList<Object>();

        list = phoneService.queryPhoneByName(phoneName);
        if (list.size()==0){
            req.getRequestDispatcher("/fail.jsp").forward(req,resp);
        }else {
            req.getRequestDispatcher("/pageQueryPhone.do").forward(req,resp);

        }
    }
}
