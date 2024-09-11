/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.model;

import edu.ijse.mvc.db.DBconnection;
import edu.ijse.mvc.dto.CustomerDto;
import java.sql.*;
import java.util.List;

/**
 *
 * @author lakshitha
 */
public class CustomerModel {
    
    public String saveCustomer(CustomerDto dto) throws ClassNotFoundException, SQLException {
        
        Connection connection = DBconnection.getInstance().getConnection();
        String sql = "INSERT INTO Customer VALUES(?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, dto.getCustID());
        stm.setString(2, dto.getCustTitle());
        stm.setString(3, dto.getCustName());
        stm.setString(4, dto.getDob());
        stm.setString(5, dto.getSalary() + "");
        stm.setString(6, dto.getCustAddress());
        stm.setString(7, dto.getCity());
        stm.setString(8, dto.getProvince());
        stm.setString(9, dto.getPostalCode());
        
        int resp = stm.executeUpdate();
        
        return resp > 0 ? "Successful" : "Fail" ;
        
    }
    
    public String updateCustomer(CustomerDto dto) throws ClassNotFoundException, SQLException {
        
        Connection connection = DBconnection.getInstance().getConnection();
        String sql = "UPDATE Customer SET CustTitle = ?, CustName = ?, DOB = ?, salary = ?, CustAddress = ?, City = ?, Province = ?, PostalCode = ? WHERE CustID = ?";

        
        PreparedStatement stm = connection.prepareStatement(sql);
        
        stm.setString(1, dto.getCustTitle());
        stm.setString(2, dto.getCustName());
        stm.setString(3, dto.getDob());
        stm.setString(4, dto.getSalary() + "");
        stm.setString(5, dto.getCustAddress());
        stm.setString(6, dto.getCity());
        stm.setString(7, dto.getProvince());
        stm.setString(8, dto.getPostalCode());
        stm.setString(9, dto.getCustID());
        
        int resp = stm.executeUpdate();
        
        return resp > 0 ? "Update Successful" : "Fail" ;
        
    }
    
    public String deleteCustomer(String id) throws ClassNotFoundException, SQLException {
        
        Connection connection = DBconnection.getInstance().getConnection();
        String sql = "DELETE FROM Customer WHERE CustID = ?";

        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, id);
        
        int resp = stm.executeUpdate();
        
        return resp > 0 ? "Delete Successful" : "Fail" ;
        
    }
    
}
