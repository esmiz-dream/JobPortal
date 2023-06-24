/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.esmizdream.futurejobs.employer.servlet;

import com.esmizdream.futurejobs.model.SubEmployerDAO;
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
public class DeleteSubEmployer extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DeleteSubEmployer</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteSubEmployer at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doDelete(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SubEmployerDAO subdao = SubEmployerDAO.getInstance();
        if (subdao.deleteAccount(Integer.parseInt(request.getParameter("id"))) == 1) {
            request.setAttribute("deleteaccount", "The Selected Account is Successfylly Deleted");
        } else {
            request.setAttribute("deleteaccount", "Failed To Delete The Selected Account");
        }
        
        response.sendRedirect(request.getContextPath()+"/ViewSubEmployer");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
