/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.esmizdream.futurejobs.job.servlet;

import com.esmizdream.futurejobs.jobcategory.JobCategoryBean;
import com.esmizdream.futurejobs.model.JobCategoryDAO;
import com.esmizdream.futurejobs.model.JobDAO;
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
import java.sql.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
@MultipartConfig()
public class AddJob extends HttpServlet {

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
            out.println("<title>Servlet AddJob</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddJob at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JobCategoryDAO categorydao = JobCategoryDAO.getInstance();
        List<JobCategoryBean> category = new ArrayList<JobCategoryBean>();
        category = categorydao.fetchAll();

        request.setAttribute("category", category);
        RequestDispatcher dispatch = request.getRequestDispatcher("AddJob.jsp");
        dispatch.forward(request, response);
//         response.sendRedirect("AddJob.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JobDAO jobdao = JobDAO.getInstance();
        FileDao obj_file = FileDao.getInstance();
        DateTime obj_date = DateTime.getInstance();
        JobBean job = new JobBean();

        //id, job, title, vacancy_id, post_date, deadline, min_experiance, max_experiance, salary, description,
        // attachment, image, work_place, category, job_modality, applied_in, status, created_at, last_modified--
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(new SimpleDateFormat().parse(request.getParameter("deadline")));
        } catch (ParseException ex) {
//         commeted for generated error bu fix laters   Logger.getLogger(AddJob.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Timestamp deadline = new java.sql.Timestamp(cal.getTimeInMillis());
        job.setDeadline(deadline);

//        add from employer session id
        job.setEmployer(3);
        job.setTitle(request.getParameter("title"));
        job.setPost_date(obj_date.getSqlDateTime());
        job.setVacancy_id(request.getParameter("vacancy_id"));
        job.setMin_experiance(Integer.parseInt(request.getParameter("min_experience")));
        job.setMax_experiance(Integer.parseInt(request.getParameter("max_experience")));
        job.setSalary(Integer.parseInt(request.getParameter("salary")));
        job.setDescription(request.getParameter("description"));
        job.setWork_place(request.getParameter("work_place"));
        job.setCategory(Integer.parseInt(request.getParameter("job_category")));

        String job_modality[] = request.getParameterValues("job_modality");
        StringJoiner modality = new StringJoiner(";");
        for (String a : job_modality) {
            modality.add(a);
        }
        job.setJob_modality(modality.toString());
        
        
        String applied_in[]=request.getParameterValues("applied_in");
        StringJoiner applied=new StringJoiner(";");
        for (String a : applied_in) {
            applied.add(a);
        }
        job.setApplied_in(applied.toString());
        job.setStatus("Active");
        job.setCreated_at(obj_date.getSqlDateTime());

//        attachment
        Part attachment = request.getPart("attachment");
        Part image = request.getPart("image");

        if (obj_file.saveFile(attachment, "job", "attachment")) {
            job.setAttachment("job/attachment/".concat(attachment.getSubmittedFileName()));
        }
        
        if (obj_file.saveFile(image, "job", "image")) {
            job.setImage("job/image/".concat(image.getSubmittedFileName()));
        }

        if (jobdao.insert(job) == 1) {
            request.setAttribute("newjob", "New Job Vacancy is Sccessfully Posted");
        } else {
            request.setAttribute("newjob", "New Job Vacancy is Failed to Post to Concat System Administarator");
        }
        response.sendRedirect(request.getContextPath() + "/ViewJob");
        System.out.println(deadline);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
