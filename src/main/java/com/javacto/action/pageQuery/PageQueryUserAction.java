package com.javacto.action.pageQuery;

import com.javacto.po.User;
import com.javacto.service.UserService;
import com.javacto.service.UserServiceImpl;
import com.javacto.util.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/pageQueryUser.do")
public class PageQueryUserAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String encoding = this.getServletContext().getInitParameter("encoding");
        req.setCharacterEncoding(encoding);
        resp.setContentType("text/html;charset=" + encoding);

        PageInfo pageInfo = new PageInfo();

        String strPageNo = req.getParameter("pageNo");
        if (null!=strPageNo){
            int pageNo1 = Integer.parseInt(strPageNo);
            pageInfo.setPageNo(pageNo1);
        }

        UserService userService = new UserServiceImpl();
        int totalCount = userService.getTotalCount();      //获得总查询记录
        pageInfo.setTotalCount(totalCount);

        List<User> users = userService.pageQueryUser(pageInfo);

        int totalPageCount = pageInfo.getTotalPageCount();    //获得总页数
        int pageNo = pageInfo.getPageNo();           //当前页
        req.setAttribute("users",users);
        req.setAttribute("totalCount",totalCount);
        req.setAttribute("totalPageCount",totalPageCount);
        req.setAttribute("pageNo",pageNo);

        req.getRequestDispatcher("/pageQueryUser.jsp").forward(req,resp);
    }
}
