/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.esmizdream.futurejobs.jobcategory;

import com.esmizdream.futurejobs.model.JobCategoryDAO;
import com.esmizdream.futurejobs.resources.DateTime;
import jakarta.servlet.RequestDispatcher;
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
public class AddJobCategory extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddJobCategory</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddJobCategory at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("AddJobCategory.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JobCategoryBean category = JobCategoryBean.getInstance();
        JobCategoryDAO categorydao = JobCategoryDAO.getInstance();
        DateTime time = DateTime.getInstance();

        category.setTitle(request.getParameter("title"));
        System.out.println(request.getParameter("title"));
        category.setStatus("suspended");
        category.setCreated_at(time.getSqlDateTime());

        if (categorydao.insert(category) == 1) {
            request.setAttribute("newcategory", "New Job Category Successfully Added");
        } else {
            request.setAttribute("newcategory", "New Job Category Successfully Added");
        }
//        RequestDispatcher dispatch=request.getRequestDispatcher(request.getContextPath() "/ViewJobCategory");
//        dispatch.forward(request, response);
        response.sendRedirect(request.getContextPath()+"/ViewJobCategory");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
