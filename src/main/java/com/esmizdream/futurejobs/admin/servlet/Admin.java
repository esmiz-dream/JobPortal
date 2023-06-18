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
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
@MultipartConfig()

public class Admin extends HttpServlet {

    private AdminModel adminmodel;
    private DateTime obj_datetime;
    private InputStream file_stream;
    private FileOutputStream fout;
    private ResultSet resultset;
    private final String dir_path = "D:/MyLab/ProjectFile/futurejobs/attachment/admin";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Admin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Admin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getRequestURI().substring(request.getContextPath().length());

        System.out.println(request.getMethod() + "  " + path);
        adminmodel = AdminModel.getInstance();
        resultset = adminmodel.fetchAll();
        List<AdminBean> admins = new ArrayList<AdminBean>();
        int i = 0;
        try {
            while (resultset.next()) {
                admins.add(new AdminBean());
                admins.get(i).setId(resultset.getInt("id"));
                admins.get(i).setName(resultset.getString("name"));
                admins.get(i).setEmail(resultset.getString("email"));
                admins.get(i).setStatus(resultset.getString("status"));
                admins.get(i).setPhotoUrl(resultset.getString("photo"));
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher dispatch_view = request.getRequestDispatcher("RUDAdmin.jsp");
        request.setAttribute("AllAdmin", admins);
        dispatch_view.forward(request, response);
//        List<Admin> list = Collections.singletonList(request.getAttribute("AllAdmin"));
//List list = new ArrayList<request.getAttribute("AllAdmin")>();
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdminBean adminbean = new AdminBean();
        adminbean.setName(request.getParameter("name"));
        adminbean.setPassword(request.getParameter("password"));
        adminbean.setEmail(request.getParameter("email"));

//        git file set path name and save file to local directory
        Part user_photo = request.getPart("photo");
        FileDao obj_file = FileDao.getInstance();
        if (obj_file.saveFile(user_photo, "Admin", "photo")) {
            adminbean.setPhotoUrl("admin/photo/" + user_photo.getSubmittedFileName());
        }
//        create attachment/admin directory if not exist
//        File file_path = new File(dir_path);
//        if (!file_path.exists()) {
//            file_path.mkdirs();
//
//        }

//        if (user_photo != null && file_path.exists()) {
//            String upload_path = dir_path.concat("/").concat(user_photo.getSubmittedFileName());
//            fout = new FileOutputStream(upload_path);
//            file_stream = user_photo.getInputStream();
//            byte[] data = new byte[file_stream.available()];
//            file_stream.read(data);
//            fout.write(data);
//            fout.close();
//
//            adminbean.setPhotoUrl("admin/" + user_photo.getSubmittedFileName());
//        }
        obj_datetime = DateTime.getInstance();
        adminbean.setCreatedAt(obj_datetime.getSqlDateTime());

        adminmodel = AdminModel.getInstance();
        int insert = adminmodel.insert(adminbean);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
