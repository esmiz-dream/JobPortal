/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esmizdream.futurejobs.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class UserAccountStatus {

    private static Jdbc jdbc;
    private static Connection conn;
    private static PreparedStatement pss;
    private static ResultSet resultset;
    private static UserAccountStatus useraccountstatus;

    public static UserAccountStatus getInstance() {
        if (useraccountstatus == null) {
            useraccountstatus = new UserAccountStatus();
        }
        return useraccountstatus;
    }

    public static int suspend(int id, String table) {
        conn = jdbc.getConnection();
        int status = 0;
        try {
            pss = conn.prepareStatement("update " + table + " set status='suspended' where id=" + id);
            status = pss.executeUpdate();
            System.out.println("suspended="+status);

        } catch (SQLException ex) {
            Logger.getLogger(UserAccountStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public static int unsuspend(int id, String table) {
        conn = jdbc.getConnection();
        int status = 0;
        try {
            pss = conn.prepareStatement("update " + table + " set status='active' where id=" + id);
            status = pss.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserAccountStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
}
