package com.academy.filters;

import com.academy.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter(urlPatterns = "/login")
public class UserFilter implements Filter {
    private static final Logger LOGGER = LogManager.getLogger(com.academy.filters.UserFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String login = servletRequest.getParameter("login");
        String password = servletRequest.getParameter("password");


        if (UserService.getInstance().checkLoginPassword(login, password)) {
            LOGGER.info(String.format("Successful logging for user %s", login));
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            LOGGER.info(String.format("Failed logging for user %s", login));
            servletRequest.setAttribute("isLogged","false");
            servletRequest.getRequestDispatcher("index.jsp").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
