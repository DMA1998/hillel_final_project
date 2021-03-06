package com.mykh.videolib.servlet;

import com.mykh.videolib.dao.UserDao;
import com.mykh.videolib.entity.User;
import com.mykh.videolib.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    private UserService userService;
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
        userDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User user = new User(login, Integer.parseInt(password));

        if (userService.isAuthorized(user, userDao.users())) {
            request.getSession().setAttribute("user", user);
            getServletContext().getRequestDispatcher("/jsp/removeFilmsByYear.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }
    }
}
