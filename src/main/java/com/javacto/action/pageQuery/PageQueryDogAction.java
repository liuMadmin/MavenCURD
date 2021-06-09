package com.javacto.action.pageQuery;

import com.javacto.po.Dog;
import com.javacto.service.DogService;
import com.javacto.service.DogServiceImpl;
import com.javacto.util.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/pageQueryDog.do")
public class PageQueryDogAction extends HttpServlet {
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

        DogService dogService = new DogServiceImpl();
        int totalCount = dogService.getTotalCount();   //获得总查询记录
        pageInfo.setTotalCount(totalCount);

        List<Dog> dogs = dogService.pageQueryDog(pageInfo);

        int totalPageCount = pageInfo.getTotalPageCount();    //获得总页数
        int pageNo = pageInfo.getPageNo();           //当前页
        req.setAttribute("dogs",dogs);
        req.setAttribute("totalCount",totalCount);
        req.setAttribute("totalPageCount",totalPageCount);
        req.setAttribute("pageNo",pageNo);

        req.getRequestDispatcher("/pageQueryDog.jsp").forward(req,resp);
    }
}
