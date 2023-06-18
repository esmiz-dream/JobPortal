/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package com.esmizdream.futurejobs.formvalidation;

import com.esmizdream.futurejobs.admin.servlet.AdminBean;
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
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import org.apache.commons.validator.routines.EmailValidator;

/**
 *
 * @author hp
 */
public class EditAdminValidation implements Filter {

    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public EditAdminValidation() {
    }

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("EditAdminValidation:DoBeforeProcessing");
        }

    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("EditAdminValidation:DoAfterProcessing");
        }

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

        HttpServletRequest http_request = (HttpServletRequest) request;
        String name = request.getParameter("name");

        if (http_request.getMethod().equalsIgnoreCase("POST")) {
            if (name == null) {
                status = false;
                request.setAttribute("errName", "Name can not be empty");
                System.out.println("name null");
            }
            String password = "";
            password = request.getParameter("password");
            String confirmPassword = "";
            confirmPassword = request.getParameter("confirmPassword");

            
             
            if (password != null || confirmPassword != null) {
                if (!password.equalsIgnoreCase(confirmPassword)) {
                    status = false;
                    request.setAttribute("errPassword", "The password and its confirm are not the same");
                    request.setAttribute("errConfpassword", "The password and its confirm are not the same");
                }
            }
            String email = request.getParameter("email");
            if (checkIsEmpty(email) || email.isEmpty()) {
                status = false;                System.out.println("email null");

                request.setAttribute("errEmail", "Email can not be empty");
            }

            boolean vldEmail = EmailValidator.getInstance().isValid(email);
            if (!vldEmail && !checkIsEmpty(email)) {
                status = false;
                request.setAttribute("errEmail", "Email format not valid");
            }
            if (!status) {
                RequestDispatcher dispatch_adduser = request.getRequestDispatcher("/EditAdmin.jsp");
//                request.getParameter("adminuser");
//                List<AdminBean> admin = request.getParameter("adminuser");
//               String AdminBeanObjectId=request.getParameter("AdminBeanObjectId");
//               AdminBean admin = http_request.getSession().getAttribute(AdminBeanObjectId);
//                request.setAttribute("adminuser", admin);
//                dispatch_adduser.forward(request, response);
                System.out.println("inside dispatch");

            } else {
                chain.doFilter(request, response);
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("EditAdminValidation:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("EditAdminValidation()");
        }
        StringBuffer sb = new StringBuffer("EditAdminValidation(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);

        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                pw.print(stackTrace);
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}
