/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esmizdream.futurejobs.model;

import com.esmizdream.futurejobs.employer.servlet.EmployerBean;
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
public class EmployerDAO {

    private static Jdbc jdbc;
    private static Connection conn;
    private static PreparedStatement pss;
    private static ResultSet rs;
    private static EmployerDAO employerdao;
    private static int status = 0;
    private static String query = "";
    private static EmployerBean employer;

    private EmployerDAO() {
        jdbc.getInstance();
    }

    public static EmployerDAO getInstance() {
        if (employerdao == null) {
            employerdao = new EmployerDAO();
        }
        return employerdao;
    }

    public static int insert(EmployerBean bean) {
        conn = jdbc.getConnection();
        query = "insert into employer(email, password, company_name, tin_number, phone, contact_name, logo, status, created_at) values(?,?,?,?,?,?,?,?,?)";
        try {
            pss = conn.prepareStatement(query);
            pss.setString(1, bean.getEmail());
            pss.setString(2, bean.getPassword());
            pss.setString(3, bean.getCompany_name());
            pss.setString(4, bean.getTin_number());
            pss.setString(5, bean.getPhone());
            pss.setString(6, bean.getContact_name());
//            save file before file path save to table in the cotroller servlet
            pss.setString(7, bean.getLogo());
            pss.setString(8, bean.getStatus());
            pss.setTimestamp(9, bean.getCreated_at());
            status = pss.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(EmployerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public static List<EmployerBean> fetchAll() {
        List<EmployerBean> employers = new ArrayList<EmployerBean>();
        conn = jdbc.getConnection();
        query = "select * from employer";
        int i = 0;
        try {
            pss = conn.prepareStatement(query);
            rs = pss.executeQuery();
            while (rs.next()) {
                employers.add(new EmployerBean());
                employers.get(i).setId(rs.getInt("id"));
                employers.get(i).setEmail(rs.getString("email"));
                employers.get(i).setPassword(rs.getString("password"));
                employers.get(i).setCompany_name(rs.getString("company_name"));
                employers.get(i).setTin_number(rs.getString("tin_number"));
                employers.get(i).setPhone(rs.getString("phone"));
                employers.get(i).setContact_name(rs.getString("contact_name"));
                employers.get(i).setLogo(rs.getString("logo"));
                employers.get(i).setStatus(rs.getString("status"));
                employers.get(i).setCreated_at(rs.getTimestamp("created_at"));
                employers.get(i).setLast_modified(rs.getTimestamp("last_modified"));

                System.out.println(rs.getString("contact_name"));
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return employers;
    }

    public static EmployerBean fetchById(int id) {
        conn = jdbc.getConnection();
        query = "select * from employer where id=?";
        try {
            pss = conn.prepareStatement(query);
            pss.setInt(1, id);
            rs = pss.executeQuery();
            rs.next();
            employer = EmployerBean.getInstance();
            employer.setId(rs.getInt("id"));
            employer.setEmail(rs.getString("email"));
            employer.setPassword(rs.getString("password"));
            employer.setCompany_name(rs.getString("company_name"));
            employer.setTin_number(rs.getString("tin_number"));
            employer.setPhone(rs.getString("phone"));
            employer.setContact_name(rs.getString("contact_name"));

            employer.setLogo(rs.getString("logo"));
            employer.setStatus(rs.getString("status"));
            employer.setCreated_at(rs.getTimestamp("created_at"));
            employer.setLast_modified(rs.getTimestamp("last_modified"));

        } catch (SQLException ex) {
            Logger.getLogger(EmployerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employer;
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
