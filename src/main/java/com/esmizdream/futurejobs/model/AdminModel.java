/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esmizdream.futurejobs.model;

import com.esmizdream.futurejobs.admin.servlet.AdminBean;
import com.esmizdream.futurejobs.resources.FileDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class AdminModel {

    private static AdminModel admin;
    private static Jdbc jdbc;
    private static Connection conn;
    private static PreparedStatement pss;
    private static ResultSet resultset;

    private AdminModel() {
        jdbc = Jdbc.getInstance();
    }

    public static AdminModel getInstance() {
        if (admin == null) {
            admin = new AdminModel();
        }
        return admin;
    }

    public static int insert(AdminBean adminbean) {
        conn = jdbc.getConnection();
        int status = 0;
        try {
            pss = conn.prepareStatement("insert into admin(name,password,email,photo,created_at) values(?,?,?,?,?)");
            pss.setString(1, adminbean.getName());
            pss.setString(2, adminbean.getPassword());
            pss.setString(3, adminbean.getEmail());
            pss.setString(4, adminbean.getPhotoUrl());
            pss.setTimestamp(5, adminbean.getCreatedAt());
            status = pss.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public static ResultSet fetchAll() {
        conn = jdbc.getConnection();
        try {
            pss = conn.prepareStatement("select * from admin");
            resultset = pss.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(AdminModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultset;
    }

    public static ResultSet fetchById(int id) {
        conn = jdbc.getConnection();
        try {
            pss = conn.prepareStatement("select * from Admin where id=?");
            pss.setInt(1, id);
            resultset = pss.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(AdminModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultset;
    }

    public static int update(String table, int id, ArrayList<String> columns, ArrayList<String> values) {
        conn = jdbc.getConnection();
        System.out.println("updating "+columns.size());
        int status = 0;
        int i=0;
        try {
            for (String column : columns) {
                System.out.println(column+" "+values.get(i));
                pss = conn.prepareStatement("update " + table + " set "+ column + "=? where id=?");
                pss.setString(1, values.get(i) );
                pss.setInt(2, id);
                status = pss.executeUpdate();
                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserAccountStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
}
