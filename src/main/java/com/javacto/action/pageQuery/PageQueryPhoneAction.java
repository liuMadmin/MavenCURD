package com.javacto.action.pageQuery;

import com.javacto.po.Phone;
import com.javacto.service.PhoneService;
import com.javacto.service.PhoneServiceImpl;
import com.javacto.util.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/pageQueryPhone.do")
public class PageQueryPhoneAction extends HttpServlet {
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

        PhoneService phoneService = new PhoneServiceImpl();
        int totalCount = phoneService.getTotalCount();   //获得总查询记录
        pageInfo.setTotalCount(totalCount);

        List<Phone> phones = phoneService.pageQueryPhone(pageInfo);

        int totalPageCount = pageInfo.getTotalPageCount();    //获得总页数
        int pageNo = pageInfo.getPageNo();           //当前页
        req.setAttribute("phones",phones);
        req.setAttribute("totalCount",totalCount);
        req.setAttribute("totalPageCount",totalPageCount);
        req.setAttribute("pageNo",pageNo);

        req.getRequestDispatcher("/pageQueryPhone.jsp").forward(req,resp);
    }
}
