/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esmizdream.futurejobs.model;

import com.esmizdream.futurejobs.employer.servlet.EmployerBean;
import com.esmizdream.futurejobs.jobcategory.JobCategoryBean;
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
public class JobCategoryDAO {

    private static Jdbc jdbc;
    private static Connection conn;
    private static PreparedStatement pss;
    private static ResultSet rs;
    private static JobCategoryDAO categorydao;
    private static int status = 0;
    private static String query = "";
    private static JobCategoryBean categorybean;

    private JobCategoryDAO() {
        jdbc.getInstance();
    }

    public static JobCategoryDAO getInstance() {
        if (categorydao == null) {
            categorydao = new JobCategoryDAO();
        }
        return categorydao;
    }

    public static int insert(JobCategoryBean bean) {
        conn = jdbc.getConnection();
        query = "insert into job_catagory(title,status, created_at) values( ?,?,?)";
        try {
            pss = conn.prepareStatement(query);
            pss.setString(1, bean.getTitle());
            pss.setString(2, bean.getStatus());
            pss.setTimestamp(3, bean.getCreated_at());
            status = pss.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(EmployerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public static List<JobCategoryBean> fetchAll() {
        List<JobCategoryBean> categories = new ArrayList<JobCategoryBean>();
        conn = jdbc.getConnection();
        query = "select * from job_catagory";
        int i = 0;
        try {
            pss = conn.prepareStatement(query);
            rs = pss.executeQuery();
            while (rs.next()) {
                categories.add(new JobCategoryBean());
                categories.get(i).setId(rs.getInt("id"));
                categories.get(i).setTitle(rs.getString("title"));
                categories.get(i).setStatus(rs.getString("status"));
                categories.get(i).setCreated_at(rs.getTimestamp("created_at"));
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return categories;
    }

    public static JobCategoryBean fetchById(int id) {
        conn = jdbc.getConnection();
        query = "select * from job_catagory where id=?";
        try {
            pss = conn.prepareStatement(query);
            pss.setInt(1, id);
            rs = pss.executeQuery();
            rs.next();
            categorybean = JobCategoryBean.getInstance();
            categorybean.setId(rs.getInt("id"));
            categorybean.setTitle(rs.getString("title"));
            categorybean.setStatus(rs.getString("status"));
            categorybean.setCreated_at(rs.getTimestamp("created_at"));
//            categorybean.setLast_modified(rs.getTimestamp("last_modified"));

        } catch (SQLException ex) {
            Logger.getLogger(EmployerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categorybean;
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
