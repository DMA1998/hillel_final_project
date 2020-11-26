package com.mykh.videolib.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/removeFilmsByYearServlet")
public class RemoveFilmFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        if (req.getSession().getAttribute("user") != null) {
            req.getRequestDispatcher("/removeFilmsByYearServlet").forward(request, response);
        } else {
            req.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }
    }
}
