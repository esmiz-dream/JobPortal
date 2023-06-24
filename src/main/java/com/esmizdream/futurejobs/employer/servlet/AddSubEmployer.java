/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.esmizdream.futurejobs.employer.servlet;

import com.esmizdream.futurejobs.model.SubEmployerDAO;
import com.esmizdream.futurejobs.resources.DateTime;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
public class AddSubEmployer extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddSubEmployer</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddSubEmployer at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //    id, employer, name, email, password, account_type, department_name, status, created_at, last_modified

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //    id, employer, name, email, password, account_type, department_name, status, created_at, last_modified
        SubEmployerDAO subdao = SubEmployerDAO.getInstance();
        SubEmployerBean sub_employer = new SubEmployerBean();
        DateTime date = DateTime.getInstance();
//        id get from session on the employer login id
        sub_employer.setEmployer(5);
        sub_employer.setName(request.getParameter("name"));
        sub_employer.setEmail(request.getParameter("email"));
        sub_employer.setPassword(request.getParameter("password"));
        sub_employer.setAccount_type(request.getParameter("account_type"));
        sub_employer.setDepartment_name(request.getParameter("department_name"));
        sub_employer.setStatus("Active");
        sub_employer.setCreated_at(date.getSqlDateTime());
System.out.println(request.getParameter("name"));
        if (subdao.insert(sub_employer) == 1) {
            request.setAttribute("addsub_employer", "Sub Account Sccessfully Created");
            System.out.println("---- you are amazing----");
        } else {
            request.setAttribute("addsub_employer", "Sub Account Failed to Create!! Contact to System Administrator");
        }
        response.sendRedirect(request.getContextPath()+"/ViewSubEmployer");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
