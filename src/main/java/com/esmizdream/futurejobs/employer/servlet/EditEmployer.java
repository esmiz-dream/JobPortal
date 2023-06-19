/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.esmizdream.futurejobs.employer.servlet;

import com.esmizdream.futurejobs.model.EmployerDAO;
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
import jakarta.xml.ws.Dispatch;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
@MultipartConfig()
public class EditEmployer extends HttpServlet {

    private EmployerDAO empdao;
    private EmployerBean employer;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditEmployer</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditEmployer at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        empdao = EmployerDAO.getInstance();
        employer = empdao.fetchById(Integer.parseInt(request.getParameter("id")));
        List<EmployerBean> employerlist = new ArrayList<EmployerBean>();
        employerlist.add(employer);
        System.out.println(employer.getCompany_name());
        RequestDispatcher dispatch = request.getRequestDispatcher("EditEmployer.jsp");
        request.setAttribute("employer", employerlist);
        dispatch.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        empdao = EmployerDAO.getInstance();
        FileDao filedao = FileDao.getInstance();
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("id->"+request.getParameter("id"));
        EmployerBean old_employer = empdao.fetchById(id);
        String company_name = request.getParameter("company_name");
        String email = request.getParameter("email");
        String tin_number = request.getParameter("tin_number");
        String phone = request.getParameter("phone");
        String contact_name = request.getParameter("contact_name");
        String password = request.getParameter("password");

        Part logo = request.getPart("logo");

//        employer.setCompany_name();
//        employer.setEmail();
//        employer.setTin_number();
//        employer.setPhone();
//        employer.setContact_name();


//        compare to old recoreded value to new submited value and change to database if any change are there
        ArrayList<String> column_updated = new ArrayList<String>();
        ArrayList<String> value_updated = new ArrayList<String>();
        int i = 0;

        if ((company_name != null && !company_name.isEmpty()) && !old_employer.getCompany_name().equalsIgnoreCase(company_name)) {
            column_updated.add("company_name");
            value_updated.add(company_name);
        }
        if ((email != null && !email.isEmpty()) && !old_employer.getEmail().equalsIgnoreCase(email)) {
            column_updated.add("email");
            value_updated.add(email);
        }
        if ((tin_number != null && !tin_number.isEmpty()) && !old_employer.getTin_number().equalsIgnoreCase(tin_number)) {
            column_updated.add("tin_number");
            value_updated.add(tin_number);
        }
        if ((phone != null && !phone.isEmpty()) && !old_employer.getPhone().equalsIgnoreCase(phone)) {
            column_updated.add("phone");
            value_updated.add(phone);
        }
        if ((contact_name != null && !contact_name.isEmpty()) && !old_employer.getContact_name().equalsIgnoreCase(contact_name)) {
            column_updated.add("contact_name");
            value_updated.add(contact_name);
        }
        if ((password != null && !password.isEmpty()) && !old_employer.getPassword().equalsIgnoreCase(password)) {
            column_updated.add("password");
            value_updated.add(password);
        }
        if (logo.getSize() > 0 && !old_employer.getLogo().equalsIgnoreCase("employer/logo/".concat(logo.getSubmittedFileName()))) {
            if (filedao.saveFile(logo, "employer", "logo")) {
                column_updated.add("logo");
                value_updated.add("employer/logo/".concat(logo.getSubmittedFileName()));
            }
        }

        if (column_updated.size() > 0) {
            DateTime time = DateTime.getInstance();
            column_updated.add("last_modified");
            value_updated.add(String.valueOf(time.getSqlDateTime()));
        }

        int status = 0;
        status = empdao.update("employer", id, column_updated, value_updated);
        if (status == 1) {
            request.setAttribute("updated", "success");
        } else {
            request.setAttribute("updated", "failed");

        }
//            RequestDispatcher dispatch = request.getRequestDispatcher("RUDAdmin.jsp");
//            dispatch.forward(request, response);
        response.sendRedirect(request.getContextPath() + "/ViewEmployer");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
