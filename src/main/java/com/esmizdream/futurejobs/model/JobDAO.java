/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esmizdream.futurejobs.model;

import com.esmizdream.futurejobs.job.servlet.JobBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class JobDAO {

    private static Jdbc jdbc;
    private static Connection conn;
    private static PreparedStatement pss;
    private static ResultSet rs;
    private static JobDAO jobdao;
    private static int status = 0;
    private static String query = "";
    private static JobBean job;

    private JobDAO() {
        jdbc.getInstance();
    }

    public static JobDAO getInstance() {
        if (jobdao == null) {
            jobdao = new JobDAO();
        }
        return jobdao;
    }

    public static int insert(JobBean bean) {
        conn = jdbc.getConnection();
        query = "insert into job(employer, title, vacancy_id, post_date, deadline, min_experiance, max_experiance, salary, "
                + "description, attachment, image, work_place, category, job_modality, applied_in, status, created_at) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//        total column=17
        try {
            pss = conn.prepareStatement(query);
            pss.setInt(1, bean.getEmployer());
            pss.setString(2, bean.getTitle());
            pss.setString(3, bean.getVacancy_id());
            pss.setTimestamp(4, bean.getPost_date());
            pss.setTimestamp(5, bean.getDeadline());
            pss.setInt(6, bean.getMin_experiance());
            pss.setInt(7, bean.getMax_experiance());
            pss.setInt(8, bean.getSalary());
            pss.setString(9, bean.getDescription());

            //            save file before file path save to table in the cotroller servlet
            pss.setString(10, bean.getAttachment());
            pss.setString(11, bean.getImage());

            pss.setString(12, bean.getWork_place());
            pss.setInt(13, bean.getCategory());
            pss.setString(14, bean.getJob_modality());
            pss.setString(15, bean.getApplied_in());
            pss.setString(16, bean.getStatus());
            pss.setTimestamp(17, bean.getCreated_at());
            status = pss.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(EmployerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public static List<JobBean> fetchAll() {
        List<JobBean> jobs = new ArrayList<JobBean>();
        conn = jdbc.getConnection();
        query = "select job.*, employer.company_name, job_catagory.title category_title from job inner join "
                + "employer on job.employer=employer.id inner join job_catagory on job.category=job_catagory.id";
        int i = 0;
        try {
            pss = conn.prepareStatement(query);
            rs = pss.executeQuery();
//                query = "insert into job(job, title, vacancy_id, post_date, deadline, min_experiance, max_experiance, salary, "
//                + "description, attachment, image, work_place, category, job_modality, applied_in, status, created_at) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            while (rs.next()) {
                jobs.add(new JobBean());
                jobs.get(i).setId(rs.getInt("id"));
                jobs.get(i).setEmployer(rs.getInt("employer"));
                jobs.get(i).setEmployer_name(rs.getString("company_name"));
                jobs.get(i).setTitle(rs.getString("title"));
                jobs.get(i).setVacancy_id(rs.getString("vacancy_id"));
                jobs.get(i).setPost_date(rs.getTimestamp("post_date"));
                jobs.get(i).setDeadline(rs.getTimestamp("deadline"));
                jobs.get(i).setMin_experiance(rs.getInt("min_experiance"));
                jobs.get(i).setMax_experiance(rs.getInt("max_experiance"));
                jobs.get(i).setSalary(rs.getInt("salary"));
                jobs.get(i).setDescription(rs.getString("description"));
                jobs.get(i).setAttachment(rs.getString("attachment"));
                jobs.get(i).setImage(rs.getString("image"));
                jobs.get(i).setWork_place(rs.getString("work_place"));
                jobs.get(i).setCategory(rs.getInt("category"));
                jobs.get(i).setCategory_name(rs.getString("category_title"));
                jobs.get(i).setJob_modality(rs.getString("job_modality"));
                jobs.get(i).setApplied_in(rs.getString("applied_in"));
                jobs.get(i).setStatus(rs.getString("status"));
                jobs.get(i).setCreated_at(rs.getTimestamp("created_at"));
                jobs.get(i).setLast_modified(rs.getTimestamp("last_modified"));

                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JobDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return jobs;
    }

    public static JobBean fetchById(int id) {
        conn = jdbc.getConnection();
        query = "select job.*, employer.company_name, job_catagory.title category_title from job "
                + "inner join employer on job.employer=employer.id "
                + "inner join job_catagory on job.category=job_catagory.id "
                + "where job.id=?";
        JobBean job = new JobBean();

        try {
            pss = conn.prepareStatement(query);
            pss.setInt(1, id);
            rs = pss.executeQuery();
            rs.next();
            job.setId(rs.getInt("id"));
            job.setEmployer(rs.getInt("employer"));
            job.setEmployer_name(rs.getString("company_name"));
            job.setTitle(rs.getString("title"));
            job.setVacancy_id(rs.getString("vacancy_id"));
            job.setPost_date(rs.getTimestamp("post_date"));
            job.setDeadline(rs.getTimestamp("deadline"));
            job.setMin_experiance(rs.getInt("min_experiance"));
            job.setMax_experiance(rs.getInt("max_experiance"));
            job.setSalary(rs.getInt("salary"));
            job.setDescription(rs.getString("description"));
            job.setAttachment(rs.getString("attachment"));
            job.setImage(rs.getString("image"));
            job.setWork_place(rs.getString("work_place"));
            job.setCategory(rs.getInt("category"));
            job.setCategory_name(rs.getString("category_title"));
            job.setJob_modality(rs.getString("job_modality"));
            job.setApplied_in(rs.getString("applied_in"));
            job.setStatus(rs.getString("status"));
            job.setCreated_at(rs.getTimestamp("created_at"));
            job.setLast_modified(rs.getTimestamp("last_modified"));
            System.out.println(rs.getInt("id"));
        } catch (SQLException ex) {
            Logger.getLogger(JobDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return job;
    }

    public static int update(String table, int id, List<String> columns, List<String> values) {
        conn = jdbc.getConnection();
        int i = 0;
        try {

            for (String column : columns) {
                query = "update " + table + " set " + column + "=? where id=?";
                pss = conn.prepareStatement(query);
                pss.setString(1, values.get(i));
                pss.setInt(2, id);
                status = pss.executeUpdate();
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

}
