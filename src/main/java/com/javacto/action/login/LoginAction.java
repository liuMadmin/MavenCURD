package com.javacto.action.login;
/*
* 控制层     调用业务层的方法
* */

/*
* 浏览器访问时servlet容器实例化servlet对象-->init()方法-->调用service()方法-->一般关闭tomcat时调用destroy()方法
* web.xml可以配置启动时实例化servlet对象
* */
import com.javacto.service.UserService;
import com.javacto.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.HashMap;

import java.util.Set;

@WebServlet("/loginUser.do")
public class LoginAction extends HttpServlet {

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
        String pwd = req.getParameter("pwd");

        UserService userService = new UserServiceImpl();
        HashMap<String,String> hashMap = new HashMap<String,String>();

        hashMap = userService.queryUserNP();
        Set<String> keySet = hashMap.keySet();
        for (String key:keySet){
            if (key.equals(userName)&&hashMap.get(key).equals(pwd)) {
                req.getRequestDispatcher("/pageQueryUser.do").forward(req, resp);
                //请求转发的方式跳转页面
                //重定向跳转页面
                //resp.sendRedirect("success.jsp");
            }
        }

        req.getRequestDispatcher("/fail.jsp").forward(req,resp);
    }
}
