/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.esmizdream.futurejobs.admin.servlet;

import com.esmizdream.futurejobs.model.AdminModel;
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
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
@MultipartConfig()
public class EditAdmin extends HttpServlet {

    private AdminModel adminmodel;
    private final static String dir_path = "D:/MyLab/ProjectFile/futurejobs/attachment/";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditAdmin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditAdmin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FileDao filedao = FileDao.getInstance();
        AdminBean adminbean = new AdminBean();
        DateTime datetime = DateTime.getInstance();
        adminmodel = AdminModel.getInstance();
        ResultSet rs = adminmodel.fetchById(Integer.parseInt(request.getParameter("id")));
        BufferedImage photo = null;
        try {
            rs.next();
            adminbean.setId(rs.getInt("id"));
            adminbean.setName(rs.getString("name"));
            adminbean.setEmail(rs.getString("email"));
            adminbean.setPhotoUrl(rs.getString("photo"));
//            photo = filedao.readImage(adminbean.getPhotoUrl(), "Admin");
            adminbean.setLastModified(datetime.getSqlDateTime());
        } catch (SQLException ex) {
            Logger.getLogger(EditAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<AdminBean> admin = new ArrayList<AdminBean>();
        admin.add(adminbean);

        RequestDispatcher dispatch = request.getRequestDispatcher("EditAdmin.jsp");
        request.setAttribute("adminuser", admin);

////        from https://stackoverflow.com/questions/4253660/passing-an-object-from-jsp-page-back-to-servlet
//        String AdminBeanObjectId = UUID.randomUUID().toString();
//        request.getSession().setAttribute(AdminBeanObjectId, adminbean);
//        request.setAttribute("AdminBeanObjectId", AdminBeanObjectId);
//        
        dispatch.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdminModel admindao = AdminModel.getInstance();
        FileDao filedao = FileDao.getInstance();
        int id = Integer.parseInt(request.getParameter("id"));
        ResultSet old_admin = admindao.fetchById(id);
        try {
            old_admin.next();

//        compare to old recoreded value to new submited value and change to database if any change are there
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            Part user_photo = request.getPart("photo");

            ArrayList<String> column_updated = new ArrayList<String>();
            ArrayList<String> value_updated = new ArrayList<String>();
            int i = 0;

            if ((name != null && !name.isEmpty()) && !old_admin.getString("name").equalsIgnoreCase(name)) {
                column_updated.add("name");
                value_updated.add(name);
            }
            if ((email != null && !email.isEmpty()) && !old_admin.getString("email").equalsIgnoreCase(email)) {
                column_updated.add("email");
                value_updated.add(email);
            }
            if ((password != null && !password.isEmpty()) && !old_admin.getString("password").equalsIgnoreCase(password)) {
                column_updated.add("password");
                value_updated.add(password);
            }
            if (user_photo.getSize() > 0 && !old_admin.getString("photo").equalsIgnoreCase("admin/photo/".concat(user_photo.getSubmittedFileName()))) {
                if (filedao.saveFile(user_photo, "Admin", "photo")) {
                    column_updated.add("photo");
                    value_updated.add("admin/photo/".concat(user_photo.getSubmittedFileName()));
                }
            }

            int status = 0;
            status = admindao.update("admin", id, column_updated, value_updated);
            if (status == 1) {
                request.setAttribute("updated", "success");
            } else {
                request.setAttribute("updated", "failed");

            }
//            RequestDispatcher dispatch = request.getRequestDispatcher("RUDAdmin.jsp");
//            dispatch.forward(request, response);
            response.sendRedirect(request.getContextPath() + "/Admin");

        } catch (SQLException ex) {
            Logger.getLogger(EditAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
