/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.esmizdream.futurejobs.admin.servlet;

import com.esmizdream.futurejobs.model.AdminModel;
import com.esmizdream.futurejobs.model.UserAccountStatus;
import com.esmizdream.futurejobs.resources.FileDao;
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
public class SuspendAdmin extends HttpServlet {

    private FileDao filedao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DeleteAdmin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteAdmin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        filedao = FileDao.getInstance();
        AdminModel adminmodel = AdminModel.getInstance();
        UserAccountStatus useraccountstatus = UserAccountStatus.getInstance();
        String action = request.getParameter("action");
        int status = 0;
        if (action.equalsIgnoreCase("suspend")) {
            status = useraccountstatus.suspend(Integer.parseInt(request.getParameter("id")), "Admin");
            if (status == 1) {
                request.setAttribute("suspend", "user account sccessfully susspended");
            } else if (status == 0) {
                request.setAttribute("suspend", "user account susspending failed");
            }
        } else if (action.equalsIgnoreCase("unsuspend")) {
            status = useraccountstatus.unsuspend(Integer.parseInt(request.getParameter("id")), "Admin");
            if (status == 1) {
                request.setAttribute("suspend", "user account activated sccessfully");
            } else if (status == 0) {
                request.setAttribute("suspend", "user account activation failed!! contact your system admin");
            }
        }

        response.sendRedirect(request.getContextPath() + "/Admin");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
