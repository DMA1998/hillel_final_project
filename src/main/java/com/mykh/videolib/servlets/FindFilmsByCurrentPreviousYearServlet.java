package com.mykh.videolib.servlets;

import com.mykh.videolib.dao.FilmDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/findFilmsByCurrentPreviousYearServlet")
public class FindFilmsByCurrentPreviousYearServlet extends HttpServlet {

    private FilmDao dao;

    public FindFilmsByCurrentPreviousYearServlet() {
        dao = new FilmDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("films",dao.findFilmsByCurrentAndPreviousYear());
        getServletContext().getRequestDispatcher("/jsp/findFilmsByCurrentPreviousYear.jsp").forward(request,response);


    }
}
