package com.javacto.action.add;

import com.javacto.po.User;
import com.javacto.service.UserService;
import com.javacto.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addUser.do")
public class AddUserAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String encoding = this.getServletContext().getInitParameter("encoding");
        req.setCharacterEncoding(encoding);
        resp.setContentType("text/html;charset="+encoding);

        String userName = req.getParameter("userName");
        String strSex = req.getParameter("sex");
        int sex = Integer.parseInt(strSex);
        String address = req.getParameter("address");

        User user = new User();
        user.setUserName(userName);
        user.setSex(sex);
        user.setAddress(address);

        UserService userService = new UserServiceImpl();
        userService.addUser(user);

        req.getRequestDispatcher("/pageQueryUser.do").forward(req,resp);
    }
}
