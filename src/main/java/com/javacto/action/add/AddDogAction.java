package com.javacto.action.add;

import com.javacto.po.Dog;
import com.javacto.service.DogService;
import com.javacto.service.DogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addDog.do")
public class AddDogAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String encoding = this.getServletContext().getInitParameter("encoding");
        req.setCharacterEncoding(encoding);
        resp.setContentType("text/html;charset="+encoding);

        String dName = req.getParameter("dName");
        String strHealth = req.getParameter("health");
        int health = Integer.parseInt(strHealth);
        String strain = req.getParameter("strain");

        Dog dog = new Dog();
        dog.setdName(dName);
        dog.setHealth(health);
        dog.setStrain(strain);

        DogService dogService = new DogServiceImpl();
        dogService.addDog(dog);

        req.getRequestDispatcher("/pageQueryDog.do").forward(req,resp);
    }
}
