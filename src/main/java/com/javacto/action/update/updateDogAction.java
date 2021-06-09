package com.javacto.action.update;

import com.javacto.po.Dog;
import com.javacto.service.DogService;
import com.javacto.service.DogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateDog.do")
public class updateDogAction extends HttpServlet {
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
        int dogId = Integer.parseInt(strId);
        String dName = req.getParameter("dName");
        String strHealth = req.getParameter("health");
        int health = Integer.parseInt(strHealth);
        String strain = req.getParameter("strain");

        Dog dog = new Dog();
        dog.setId(dogId);
        dog.setdName(dName);
        dog.setHealth(health);
        dog.setStrain(strain);

        DogService dogService = new DogServiceImpl();
        dogService.updateDog(dog);

        req.getRequestDispatcher("/pageQueryDog.do").forward(req,resp);

    }
}
