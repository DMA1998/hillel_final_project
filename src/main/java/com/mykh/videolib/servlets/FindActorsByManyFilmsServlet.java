package com.mykh.videolib.servlets;

import com.mykh.videolib.dao.FilmDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findActorsByManyFilmsServlet")
public class FindActorsByManyFilmsServlet extends HttpServlet {

    private FilmDao dao;

    public FindActorsByManyFilmsServlet() {
        dao = new FilmDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/findActorsByManyFilms.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filmsQuantity = request.getParameter("filmsQuantity");
        request.setAttribute("actorsFilms", dao.findActorsByManyFilms(Integer.parseInt(filmsQuantity)));
        getServletContext().getRequestDispatcher("/jsp/findActorsByManyFilms.jsp").forward(request, response);
    }


}
