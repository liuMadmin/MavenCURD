package com.javacto.action.query;

import com.javacto.po.User;
import com.javacto.service.UserService;
import com.javacto.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/queryUserById.do")
public class QueryUserByIdAction extends HttpServlet {
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
        Integer userId = Integer.parseInt(strId);

        List<Object> list = new ArrayList<Object>();
        UserService userService = new UserServiceImpl();
        list = userService.queryUserById(userId);
        User user = (User) list.get(0);
        req.setAttribute("user",user);

        req.getRequestDispatcher("/updateUser.jsp").forward(req,resp);

    }
}
