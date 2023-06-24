/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.esmizdream.futurejobs.employer.servlet;

import com.esmizdream.futurejobs.model.SubEmployerDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class ViewSubEmployer extends HttpServlet {
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ViewSubEmployer</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewSubEmployer at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       //    id, employer, name, email, password, account_type, department_name, status, created_at, last_modified
     SubEmployerDAO subdao=SubEmployerDAO.getInstance();
     List<SubEmployerBean> sub_employer=new ArrayList<SubEmployerBean>();
     sub_employer=subdao.fetchAll();
     request.setAttribute("sub_employer", sub_employer);
     RequestDispatcher dispatch=request.getRequestDispatcher("ViewSubEmployer.jsp");
     dispatch.forward(request, response);
    }

     
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
