package com.academy.filters;

import com.academy.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/login")
public class UserAuth implements Filter {
    private static final Logger LOGGER = LogManager.getLogger(UserAuth.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        UserService userService = new UserService();
        String login = servletRequest.getParameter("login");
        String password = servletRequest.getParameter("password");


        if (userService.checkLoginPassword(login, password)) {
            LOGGER.info(String.format("Successful logging for user %s", login));
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
