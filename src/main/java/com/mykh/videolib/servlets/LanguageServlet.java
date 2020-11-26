package com.mykh.videolib.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;

@WebServlet("/languageServlet")
public class LanguageServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String locale = request.getParameter("language");
        session.setAttribute("locale", locale);
        Config.set(session, Config.FMT_LOCALE, locale);
        response.sendRedirect("index.jsp");

    }
}
