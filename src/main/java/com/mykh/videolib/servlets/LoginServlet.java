package com.mykh.videolib.servlets;

import com.mykh.videolib.dao.UserDao;
import com.mykh.videolib.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao = new UserDao();
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User user = new User(login,Integer.parseInt(password));

        if (dao.isAuthorized(user)) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("index.jsp");
        }else{
            request.getRequestDispatcher("/jsp/login.jsp").forward(request,response);
        }
    }
}
