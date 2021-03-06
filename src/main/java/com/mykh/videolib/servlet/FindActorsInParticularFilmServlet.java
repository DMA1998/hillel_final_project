package com.mykh.videolib.servlet;

import com.mykh.videolib.dao.FilmDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/findActorsInParticularFilmServlet")
public class FindActorsInParticularFilmServlet extends HttpServlet {

    private FilmDao dao;

    @Override
    public void init() throws ServletException {
        dao = new FilmDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/findActorsInParticularFilm.jsp").forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filmName = request.getParameter("filmName");
        request.setAttribute("actors", dao.findActorsInParticularFilm(filmName));
        getServletContext().getRequestDispatcher("/jsp/findActorsInParticularFilm.jsp").forward(request, response);



    }
}
