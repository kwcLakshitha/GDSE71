/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.db;
import java.sql.*;

/**
 *
 * @author lakshitha
 */
public class DBconnection {

    private static DBconnection dBconnection;
    private Connection connection;
    

    private DBconnection() throws ClassNotFoundException, SQLException {
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "Ijse@1234");
    }
    
    public static DBconnection getInstance() throws ClassNotFoundException, SQLException {

        if (dBconnection == null) {

            dBconnection = new DBconnection();
        }

        return dBconnection;
    }
    
    public Connection getConnection() {
    
        return connection;
    }

}
