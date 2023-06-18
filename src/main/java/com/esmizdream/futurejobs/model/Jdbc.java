/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esmizdream.futurejobs.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hp
 */
public class Jdbc {

    private static final String db_name = "futurejobs";
    private static final String user = "root";
    private static final String password = "root";
    private static final int port=3307;
    private static final String host="localhost";
    private static Jdbc jdbc;

    private Jdbc() {
    }

    public static Jdbc getInstance() {
        if (jdbc == null) {
            jdbc = new Jdbc();
        }
        return jdbc;
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/" + db_name, user, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }

}
