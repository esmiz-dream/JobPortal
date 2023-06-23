/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.esmizdream.futurejobs.employer.servlet;

import com.esmizdream.futurejobs.model.EmployerDAO;
import com.esmizdream.futurejobs.resources.DateTime;
import com.esmizdream.futurejobs.resources.FileDao;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 *
 * @author hp
 */
@MultipartConfig()
public class AddEmployer extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddEmployer</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddEmployer at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("AddEmployer.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DateTime time = DateTime.getInstance();
        FileDao obj_file = FileDao.getInstance();
        EmployerBean employer = new EmployerBean();

        Part logo = request.getPart("logo");
        employer.setCompany_name(request.getParameter("company_name"));
        employer.setEmail(request.getParameter("email"));
        employer.setTin_number(request.getParameter("tin_number"));
        employer.setPhone(request.getParameter("phone"));
        employer.setContact_name(request.getParameter("contact_name"));
        employer.setPassword(request.getParameter("password"));

        if (obj_file.saveFile(logo, "employer", "logo")) {
            employer.setLogo("employer/logo/".concat(logo.getSubmittedFileName()));
        }
        employer.setStatus("suspended");
        employer.setCreated_at(time.getSqlDateTime());

        EmployerDAO empdao = EmployerDAO.getInstance();
        if (empdao.insert(employer) == 1) {
            request.setAttribute("addemployer", "Employer Sccessfully Registered");
        } else {
            request.setAttribute("addemployer", "Employer Failed to Registered");
        }
//        RequestDispatcher dispatch = request.getRequestDispatcher("ViewEmployer");
//        dispatch.forward(request, response);
        response.sendRedirect(request.getContextPath() + "/ViewEmployer");
        

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
