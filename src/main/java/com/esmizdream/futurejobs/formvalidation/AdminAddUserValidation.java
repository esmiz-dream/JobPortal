/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package com.esmizdream.futurejobs.formvalidation;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.validator.routines.*;

/**
 *
 * @author hp
 */
public class AdminAddUserValidation implements Filter {

    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public AdminAddUserValidation() {
    }

    public boolean checkIsEmpty(String input) {
        boolean status = false;
        if (input == null) {
            status = true;
        } else {
            status = false;
        }
        return status;
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        boolean status = true;
        String name = request.getParameter("name");
        System.out.println("name =>" + name + " " + checkIsEmpty(name));
        HttpServletRequest http_request = (HttpServletRequest) request;
        if (http_request.getMethod().equalsIgnoreCase("POST")) {
            if (checkIsEmpty(name) || name.isEmpty()) {
                status = false;
                request.setAttribute("errName", "Name can not be empty");
                System.out.println("name null");
            }
            String password = request.getParameter("password");
            String confirmPassword = request.getParameter("confirmPassword");

            if (checkIsEmpty(password) || password.isEmpty()) {
                status = false;
                request.setAttribute("errPassword", "Password can not be empty");
            }
            if (checkIsEmpty(confirmPassword) || confirmPassword.isEmpty()) {
                status = false;
                request.setAttribute("errConfpassword", "You have to check confirm to policy");

            }
            if (!password.equals(confirmPassword)) {
                status = false;
                request.setAttribute("errPassword", "The password and its confirm are not the same");
                request.setAttribute("errConfpassword", "The password and its confirm are not the same");
            }
            String email = request.getParameter("email");
            if (checkIsEmpty(email) || email.isEmpty()) {
                status = false;
                request.setAttribute("errEmail", "Email can not be empty");
            }

            String country = request.getParameter("photo");
            if (checkIsEmpty(country) || country.isEmpty()) {
                //status = false;
                //request.setAttribute("errPhoto", "Country can not be empty");
            }

            boolean vldEmail = EmailValidator.getInstance().isValid(email);
            if (!vldEmail && !checkIsEmpty(email)) {
                status = false;
                request.setAttribute("errEmail", "Email format not valid");
            }
            if (!status) {
                RequestDispatcher dispatch_adduser = request.getRequestDispatcher("/AddAdmin.jsp");
                dispatch_adduser.forward(request, response);
            } else {
                chain.doFilter(request, response);
            }
        } else {
            chain.doFilter(request, response);
            System.out.println("not post request");
        }

    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    public void destroy() {
    }

    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {

        }
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}
