/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esmizdream.futurejobs.model;

import com.esmizdream.futurejobs.employer.servlet.SubEmployerBean;
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
public class SubEmployerDAO {

    private static Jdbc jdbc;
    private static Connection conn;
    private static PreparedStatement pss;
    private static ResultSet rs;
    private static SubEmployerDAO subdao;
    private static int status = 0;
    private static String query = "";
    private static SubEmployerBean sub_employer;

    private SubEmployerDAO() {
        jdbc.getInstance();
    }

    public static SubEmployerDAO getInstance() {
        if (subdao == null) {
            subdao = new SubEmployerDAO();
        }
        return subdao;
    }

    public static int insert(SubEmployerBean bean) {
        conn = jdbc.getConnection();
        query = "insert into sub_employer(employer, name, email, password, account_type, department_name, status, created_at) values(?,?,?,?,?,?,?,?)";
        try {
            pss = conn.prepareStatement(query);
            pss.setInt(1, bean.getEmployer());
            pss.setString(2, bean.getName());
            pss.setString(3, bean.getEmail());
            pss.setString(4, bean.getPassword());
            pss.setString(5, bean.getAccount_type());
            pss.setString(6, bean.getDepartment_name());
            pss.setString(7, bean.getStatus());
            pss.setTimestamp(8, bean.getCreated_at());
            status = pss.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SubEmployerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public static List<SubEmployerBean> fetchAll() {
        List<SubEmployerBean> employers = new ArrayList<SubEmployerBean>();
        conn = jdbc.getConnection();
        query = "select sub_employer.*, employer.company_name  from sub_employer "
                + "inner join employer on sub_employer.employer=employer.id";
        int i = 0;
        try {
            pss = conn.prepareStatement(query);
            rs = pss.executeQuery();
            while (rs.next()) {
                employers.add(new SubEmployerBean());
                employers.get(i).setId(rs.getInt("id"));
                employers.get(i).setId(rs.getInt("employer"));
                employers.get(i).setEmployer_name(rs.getString("company_name"));
                employers.get(i).setName(rs.getString("name"));
                employers.get(i).setEmail(rs.getString("email"));
                employers.get(i).setPassword(rs.getString("password"));
                employers.get(i).setAccount_type(rs.getString("account_type"));
                employers.get(i).setDepartment_name(rs.getString("department_name"));
                employers.get(i).setStatus(rs.getString("status"));
                employers.get(i).setCreated_at(rs.getTimestamp("created_at"));
                employers.get(i).setLast_modified(rs.getTimestamp("last_modified"));
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubEmployerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return employers;
    }

    public static SubEmployerBean fetchById(int id) {
        conn = jdbc.getConnection();
        query = "select sub_employer.*, employer.company_name from sub_employer "
                + "inner join employer on sub_employer.employer=employer.id where sub_employer.id=?";
        try {
            pss = conn.prepareStatement(query);
            pss.setInt(1, id);
            rs = pss.executeQuery();
            rs.next();
            //    id, employer, name, email, password, account_type, department_name, status, created_at, last_modified

            SubEmployerBean sub_employer = new SubEmployerBean();
            sub_employer.setId(rs.getInt("id"));
            sub_employer.setEmployer(rs.getInt("employer"));
            sub_employer.setEmployer_name(rs.getString("company_name"));
            sub_employer.setName(rs.getString("name"));

            sub_employer.setEmail(rs.getString("email"));
            sub_employer.setPassword(rs.getString("password"));
            sub_employer.setAccount_type(rs.getString("account_type"));
            sub_employer.setDepartment_name(rs.getString("department_name"));
            sub_employer.setStatus(rs.getString("status"));
            sub_employer.setCreated_at(rs.getTimestamp("created_at"));
            sub_employer.setLast_modified(rs.getTimestamp("last_modified"));

        } catch (SQLException ex) {
            Logger.getLogger(EmployerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sub_employer;
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
