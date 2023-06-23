/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.esmizdream.futurejobs.jobcategory;

import com.esmizdream.futurejobs.model.JobCategoryDAO;
import com.esmizdream.futurejobs.model.UserAccountStatus;
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
public class SuspendJobCategory extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SuspendJobCategory</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SuspendJobCategory at " + request.getContextPath() + "</h1>");
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
        JobCategoryDAO adminmodel = JobCategoryDAO.getInstance();
        UserAccountStatus useraccountstatus = UserAccountStatus.getInstance();
        String action = request.getParameter("action");
        int status = 0;
        if (action.equalsIgnoreCase("suspend")) {
            status = useraccountstatus.suspend(Integer.parseInt(request.getParameter("id")), "job_catagory");
            if (status == 1) {
                request.setAttribute("suspend", "user account sccessfully susspended");
            } else if (status == 0) {
                request.setAttribute("suspend", "user account susspending failed");
            }
        } else if (action.equalsIgnoreCase("unsuspend")) {
            status = useraccountstatus.unsuspend(Integer.parseInt(request.getParameter("id")), "job_catagory");
            if (status == 1) {
                request.setAttribute("suspend", "user account activated sccessfully");
            } else if (status == 0) {
                request.setAttribute("suspend", "user account activation failed!! contact your system admin");
            }
        }

        response.sendRedirect(request.getContextPath() + "/ViewJobCategory");
    }
 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
