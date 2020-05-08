package com.vluv.recipe_hoarder_web.controllers.filters;

import com.vluv.recipe_hoarder_core.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebFilter("/*")
public class AuthFilter implements Filter {

    private List<String> exclusions;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        exclusions = Arrays.asList(filterConfig.getServletContext().getInitParameter("login-filter-exclusion").split(","));
        exclusions.replaceAll(String::trim);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String path = ((HttpServletRequest) request).getServletPath();

        if (exclusions.stream().anyMatch(path::equals)) {
            chain.doFilter(request, response);
            return;
        }

        User currentUser = (User) ((HttpServletRequest) request).getSession().getAttribute("currentUser");

        if (currentUser == null) {
            ((HttpServletResponse)response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/login.jsp");
        }
        else{
            chain.doFilter(request, response);
        }


    }
}